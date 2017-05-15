package com.kby.home.safety.controller;

import com.kby.home.safety.Constants;
import com.kby.home.safety.api.exception.BusinessException;
import com.kby.home.safety.api.vo.RoomVo;
import com.kby.home.safety.api.web.QueryRoomStatusRequest;
import com.kby.home.safety.api.web.Response;
import com.kby.home.safety.api.web.ResponseStatus;
import com.kby.home.safety.mapper.RoomMapper;
import com.kby.home.safety.mapper.RoomMonitorMapper;
import com.kby.home.safety.model.Room;
import com.kby.home.safety.model.RoomMonitor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangpeng12 on 2017/5/15.
 */
@Controller
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private RoomMonitorMapper roomMonitorMapper;

    @RequestMapping("/queryRoomStatus")
    @ResponseBody
    public Response login(QueryRoomStatusRequest request){
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
            RoomMonitor monitor = roomMonitorMapper.getMonitorByRoomId(room.getId());
            //-----------------------------------------
            RoomVo vo = new RoomVo();
            BeanUtils.copyProperties(monitor,vo);
            BeanUtils.copyProperties(room,vo);
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
}
