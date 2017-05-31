package com.kby.home.safety.controller;

import com.kby.home.safety.Constants;
import com.kby.home.safety.api.exception.BusinessException;
import com.kby.home.safety.api.vo.RoomVo;
import com.kby.home.safety.api.vo.ThresholdVo;
import com.kby.home.safety.api.web.*;
import com.kby.home.safety.mapper.AlertMapper;
import com.kby.home.safety.mapper.RoomMapper;
import com.kby.home.safety.mapper.RoomMonitorMapper;
import com.kby.home.safety.mapper.UserMapper;
import com.kby.home.safety.model.Alert;
import com.kby.home.safety.model.Room;
import com.kby.home.safety.model.RoomMonitor;
import com.kby.home.safety.model.User;
import com.kby.home.safety.service.JPushServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


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
    @Autowired
    private JPushServiceImpl jPushService;

    private  static final SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("/queryRoomStatus")
    @ResponseBody
    @Transactional
    public Response queryRoomStatus(@RequestBody QueryRoomStatusRequest request){
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
    @RequestMapping("/setRoomThreshold")
    @ResponseBody
    @Transactional
    public Response setRoomThreshold(@RequestBody SetRoomThresholdRequest request){
        Response response = new Response();
        try{
            List<ThresholdVo> thresholdVoList = request.getThresholdVoList();
            if(thresholdVoList == null || thresholdVoList.size() != 3){
                throw new BusinessException(ResponseStatus.Invalid.getCode(), "必须同时设置三个房间的阈值");
            }
            for(ThresholdVo vo : thresholdVoList ){
                int roomType = vo.getRoomType();
                //---------------参数检查------------------
                if(roomType != Constants.ROOM_TYPE_BEDROOM &&
                        roomType != Constants.ROOM_TYPE_LIVINGROOM &&
                        roomType != Constants.ROOM_TYPE_KITCHEN){
                    throw new BusinessException(ResponseStatus.Invalid.getCode(), "您访问的房屋类型不存在");
                }
                //-----------------------------------------
                Room room = roomMapper.getRoomByRoomType(request.getAccessKey(), roomType);
                if(room == null){
                    throw new BusinessException(ResponseStatus.Invalid.getCode(), "您访问的房屋不存在");
                }
                room.setTemperatureThreshold(vo.getTemperatureThreshold());
                room.setSmokeConcentration(vo.getSmokeConcentration());
                room.setHumidityThreshold(vo.getHumidityThreshold());
                room.setUpdateTime(new Date());
                roomMapper.updateByPrimaryKey(room);
            }
            //------------------------------------------------
            response.setSuccess(true);
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
                //-----------------拼接报警内容--------------------------------
                //2017年4月17日 12:12:00 您的客厅温度超过阈值25℃产生过异常，异常值为：26℃
                StringBuilder sb = new StringBuilder();
                sb.append(fmt.format(alert.getAlertTime()))
                        .append("您的")
                        .append(Constants.ROOM_TYPE_NAME[roomType])
                        .append(Constants.ALERT_TYPE_NAME[alert.getAlertType()])
                        .append("超过阈值")
                        .append(room.getTemperatureThreshold())
                        .append("℃产生过异常，异常值为：")
                        .append( moninor.getTemperature())
                        .append("℃");
                alert.setContent(sb.toString());
                alert.setIsLatest(1);
                alertMapper.insert(alert);
                //推送通知
                jPushService.pushAlert(alert);
            }

            if(moninor.getHumidity() != null &&
                    room.getHumidityThreshold() != null &&
                    moninor.getHumidity() >room.getHumidityThreshold()){
                Alert alert = new Alert();
                alert.setRoomId(room.getId());
                alert.setUserId(user.getId());
                alert.setAlertType(Constants.ALERT_TYPE_HUMIDITY);
                alert.setAlertValue(moninor.getHumidity());
                alert.setCreateTime(new Date());
                alert.setUdpateTime(new Date());
                alert.setAlertTime(new Date());
                //-----------------拼接报警内容--------------------------------
                //2017年4月9日 12:12:00 您的厨房湿度度超过阈值29%产生过异常，异常值为：30%
                StringBuilder sb = new StringBuilder();
                sb.append(fmt.format(alert.getAlertTime()))
                        .append("您的")
                        .append(Constants.ROOM_TYPE_NAME[roomType])
                        .append(Constants.ALERT_TYPE_NAME[alert.getAlertType()])
                        .append("超过阈值")
                        .append(room.getHumidityThreshold())
                        .append("%产生过异常，异常值为：")
                        .append( moninor.getHumidity())
                        .append("%");
                alert.setContent(sb.toString());
                alert.setIsLatest(1);
                alertMapper.insert(alert);
                //推送通知
                jPushService.pushAlert(alert);
            }

            if(moninor.getSmoke() != null &&
                    room.getSmokeConcentration() != null &&
                    moninor.getSmoke() >room.getSmokeConcentration()) {
                Alert alert = new Alert();
                alert.setRoomId(room.getId());
                alert.setUserId(user.getId());
                alert.setAlertType(Constants.ALERT_TYPE_SMOKE);
                alert.setAlertValue(moninor.getSmoke());
                alert.setCreateTime(new Date());
                alert.setUdpateTime(new Date());
                alert.setAlertTime(new Date());
                //-----------------拼接报警内容--------------------------------
                //2017年4月6日 12:12:00 您的客厅烟雾浓度超过阈值1.67%FT产生过异常，异常值为：1.69%FT
                StringBuilder sb = new StringBuilder();
                sb.append(fmt.format(alert.getAlertTime()))
                        .append("您的")
                        .append(Constants.ROOM_TYPE_NAME[roomType])
                        .append(Constants.ALERT_TYPE_NAME[alert.getAlertType()])
                        .append("超过阈值")
                        .append(room.getSmokeConcentration())
                        .append("%FT产生过异常，异常值为：")
                        .append(moninor.getTemperature())
                        .append("%FT");
                alert.setContent(sb.toString());
                alert.setIsLatest(1);
                alertMapper.insert(alert);
                //推送通知
                jPushService.pushAlert(alert);
            }
                //-----------------防盗警--------------------------------
                if(request.getUserEnteredAlarm() != null && request.getUserEnteredAlarm() == true) {
                    Alert alert = new Alert();
                    alert.setRoomId(room.getId());
                    alert.setUserId(user.getId());
                    alert.setAlertType(Constants.ALERT_TYPE_USER_ENTERED);
                    alert.setAlertValue(moninor.getTemperature());
                    alert.setCreateTime(new Date());
                    alert.setUdpateTime(new Date());
                    alert.setAlertTime(new Date());
                    //-----------------拼接报警内容--------------------------------
                    //2017年4月6日 12:12:00 您的客厅烟雾浓度超过阈值1.67%FT产生过异常，异常值为：1.69%FT
                    StringBuilder sb = new StringBuilder();
                    sb.append(fmt.format(alert.getAlertTime()))
                            .append("您的")
                            .append(Constants.ROOM_TYPE_NAME[roomType])
                            .append("发生防盗警报");
                    alert.setContent(sb.toString());
                    alert.setIsLatest(1);
                    alertMapper.insert(alert);
                    //推送通知
                    jPushService.pushAlert(alert);
                }
            //-----------------火警--------------------------------
            if(moninor.getTemperature() >= 50  && moninor.getSmoke() >= 0.65) {
                Alert alert = new Alert();
                alert.setRoomId(room.getId());
                alert.setUserId(user.getId());
                alert.setAlertType(Constants.ALERT_TYPE_FIRE);
                alert.setAlertValue(1d);
                alert.setCreateTime(new Date());
                alert.setUdpateTime(new Date());
                alert.setAlertTime(new Date());
                //-----------------拼接报警内容--------------------------------
                //.2017年3月22日 12:12:00 您的客厅发生火警，温度达到50℃，烟雾浓度达到0.65%FT
                StringBuilder sb = new StringBuilder();
                sb.append(fmt.format(alert.getAlertTime()))
                        .append("您的")
                        .append(Constants.ROOM_TYPE_NAME[roomType])
                        .append("发生火警，温度达到50℃，烟雾浓度达到0.65%FT");
                alert.setContent(sb.toString());
                alert.setIsLatest(1);
                alertMapper.insert(alert);
                //推送通知
                jPushService.pushAlert(alert);
            }
                //-----------------水警----------------------------------
                    if(moninor.getTemperature() > 40 && moninor.getHumidity() >80){
                        Alert alert = new Alert();
                        alert.setRoomId(room.getId());
                        alert.setUserId(user.getId());
                        alert.setAlertType(Constants.ALERT_TYPE_WATER);
                        alert.setAlertValue(1d);
                        alert.setCreateTime(new Date());
                        alert.setUdpateTime(new Date());
                        alert.setAlertTime(new Date());
                        //-----------------拼接报警内容--------------------------------
                        //2017年3月13日 12:12:00 您的客厅发生水警，温度达到40℃，湿度达到80%。
                        StringBuilder sb = new StringBuilder();
                        sb.append(fmt.format(alert.getAlertTime()))
                                .append("您的")
                                .append(Constants.ROOM_TYPE_NAME[roomType])
                                .append("发生水警，温度达到40℃，湿度达到80%");
                        alert.setContent(sb.toString());
                        alert.setIsLatest(1);
                        alertMapper.insert(alert);
                        //推送通知
                        jPushService.pushAlert(alert);
            }
        }catch (BusinessException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "success";
    }
}
