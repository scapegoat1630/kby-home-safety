package com.kby.home.safety.controller;

import com.kby.home.safety.Constants;
import com.kby.home.safety.api.exception.BusinessException;
import com.kby.home.safety.api.vo.RoomVo;
import com.kby.home.safety.api.web.QueryRoomStatusRequest;
import com.kby.home.safety.api.web.Response;
import com.kby.home.safety.api.web.ResponseStatus;
import com.kby.home.safety.api.web.SetRoomStatusRequest;
import com.kby.home.safety.mapper.AlertMapper;
import com.kby.home.safety.mapper.RoomMapper;
import com.kby.home.safety.mapper.RoomMonitorMapper;
import com.kby.home.safety.mapper.UserMapper;
import com.kby.home.safety.model.Alert;
import com.kby.home.safety.model.Room;
import com.kby.home.safety.model.RoomMonitor;
import com.kby.home.safety.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by zhangpeng12 on 2017/5/15.
 */
@Controller
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoomMonitorMapper roomMonitorMapper;
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private AlertMapper alertMapper;

    @RequestMapping("/queryRoomStatus")
    @ResponseBody
    @Transactional
    public Response queryRoomStatus(QueryRoomStatusRequest request){
        Response response = new Response();
        try{
            int roomType = request.getRoomType();
            //---------------参数检查------------------
            if(roomType != Constants.ROOM_TYPE_BEDROOM &&
                    roomType != Constants.ROOM_TYPE_LIVINGROOM &&
                    roomType != Constants.ROOM_TYPE_KITCHEN){
                throw new BusinessException(ResponseStatus.Invalid.getCode(), "您访问的房屋类型不存在");
            }
            //-----------------------------------------
            Room room = roomMapper.getRoomByRoomType(request.getAccessKey(),request.getRoomType());
            if(room == null){
                throw new BusinessException(ResponseStatus.Invalid.getCode(), "您访问的房屋不存在");
            }
            RoomVo vo = getRoomVo(room);
            //------------------------------------------------
            response.setSuccess(true);
            response.setResult(vo);
        }catch (BusinessException e){
            response.setSuccess(false);
            response.setError(e.getMessage());
            return response;
        }catch (Exception e){
            response.setSuccess(false);
            response.setError(e.getMessage());
            return response;
        }
        return response;
    }
    @Transactional
    public RoomVo getRoomVo(Room room) {
        RoomMonitor monitor = roomMonitorMapper.getMonitorByRoomId(room.getId());
        //-----------------------------------------
        RoomVo vo = new RoomVo();
        BeanUtils.copyProperties(monitor, vo);
        BeanUtils.copyProperties(room,vo);
        //-----------------更新状态-----------------
        if(vo.getTemperature() != null &&
                vo.getTemperatureThreshold() != null &&
                vo.getTemperature() >vo.getTemperatureThreshold()){
           vo.setTemperatureStatus("异常");
        }else {
            vo.setTemperatureStatus("正常");
        }

        if(vo.getHumidity() != null &&
                vo.getHumidityThreshold() != null &&
                vo.getHumidity() >vo.getHumidityThreshold()){
            vo.setHumidityStatus("异常");
        }else {
            vo.setHumidityStatus("正常");
        }

        if(vo.getSmoke() != null &&
                vo.getSmokeConcentration() != null &&
                vo.getSmoke() >vo.getSmokeConcentration()){
            vo.setSmokeStatus("异常");
        }else {
            vo.setSmokeStatus("正常");
        }
        return vo;
    }

    @RequestMapping("/setRoomStatusPage")
    public String setRoomStatusPage(){
        return "room";
    }
    @RequestMapping("/setRoomStatus")
    @Transactional
    public String setRoomStatus( SetRoomStatusRequest request){
        try{
            int roomType = request.getRoomType();
            //---------------参数检查------------------
            if(roomType != Constants.ROOM_TYPE_BEDROOM &&
                    roomType != Constants.ROOM_TYPE_LIVINGROOM &&
                    roomType != Constants.ROOM_TYPE_KITCHEN){
                throw new BusinessException(ResponseStatus.Invalid.getCode(), "您访问的房屋类型不存在");
            }
            //--------------根据用户名查找当前用户------
            User user = userMapper.getUserByUsername(request.getUsername());
            //-----------------------------------------
            Room room = roomMapper.getRoomByRoomType(user.getId(),request.getRoomType());
            if(room == null){
                throw new BusinessException(ResponseStatus.Invalid.getCode(), "您访问的房屋不存在");
            }
            //--------------更新当前房间的记录--------------
            RoomMonitor monitor = roomMonitorMapper.getMonitorByRoomId(room.getId());
            monitor.setIsLatest(0);
            roomMonitorMapper.updateByPrimaryKey(monitor);
            //-------------插入新的monitor----------------------------
            RoomMonitor moninor = new RoomMonitor();
            moninor.setIsLatest(1);
            moninor.setCreateTime(new Date());
            moninor.setUpdateTime(new Date());
            moninor.setRoomId(room.getId());
            moninor.setHumidity(request.getHumidity());
            moninor.setTemperature(request.getTemperature());
            moninor.setSmoke(request.getSmoke());
            roomMonitorMapper.insert(moninor);
            //-------------如果大于了阈值，触发报警--------------------
            if(moninor.getTemperature() != null &&
                    room.getTemperatureThreshold() != null &&
                    moninor.getTemperature() >room.getTemperatureThreshold()){
                Alert alert = new Alert();
                alert.setRoomId(room.getId());
                alert.setUserId(user.getId());
                alert.setAlertType(Constants.ALERT_TYPE_TEMPERATURE);
                alert.setAlertValue(moninor.getTemperature());
                alert.setCreateTime(new Date());
                alert.setUdpateTime(new Date());
                alert.setAlertTime(new Date());
                alertMapper.insert(alert);
            }

            if(moninor.getHumidity() != null &&
                    room.getHumidityThreshold() != null &&
                    moninor.getHumidity() >room.getHumidityThreshold()){
                Alert alert = new Alert();
                alert.setRoomId(room.getId());
                alert.setUserId(user.getId());
                alert.setAlertType(Constants.ALERT_TYPE_TEMPERATURE);
                alert.setAlertValue(moninor.getTemperature());
                alert.setCreateTime(new Date());
                alert.setUdpateTime(new Date());
                alert.setAlertTime(new Date());
                alertMapper.insert(alert);
            }

            if(moninor.getSmoke() != null &&
                    room.getSmokeConcentration() != null &&
                    moninor.getSmoke() >room.getSmokeConcentration()){
                Alert alert = new Alert();
                alert.setRoomId(room.getId());
                alert.setUserId(user.getId());
                alert.setAlertType(Constants.ALERT_TYPE_TEMPERATURE);
                alert.setAlertValue(moninor.getTemperature());
                alert.setCreateTime(new Date());
                alert.setUdpateTime(new Date());
                alert.setAlertTime(new Date());
                alertMapper.insert(alert);
            }
        }catch (BusinessException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "success";
    }
}
