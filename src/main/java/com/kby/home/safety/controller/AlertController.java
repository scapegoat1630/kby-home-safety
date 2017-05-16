package com.kby.home.safety.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kby.home.safety.Constants;
import com.kby.home.safety.api.exception.BusinessException;
import com.kby.home.safety.api.vo.AlertVo;
import com.kby.home.safety.api.vo.RoomVo;
import com.kby.home.safety.api.web.*;
import com.kby.home.safety.mapper.AlertMapper;
import com.kby.home.safety.mapper.RoomMapper;
import com.kby.home.safety.mapper.UserMapper;
import com.kby.home.safety.model.Alert;
import com.kby.home.safety.model.AlertExample;
import com.kby.home.safety.model.Room;
import com.kby.home.safety.model.User;
import com.kby.home.safety.util.PageUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by zhangpeng12 on 2017/5/16.
 */
@Controller
@RequestMapping("/alert")
public class AlertController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AlertMapper alertMapper;
    @Autowired
    private RoomController roomController;
    @Autowired
    private RoomMapper roomMapper;

    @RequestMapping("/queryAlert")
    @ResponseBody
    @Transactional
    public Response queryAlert(QueryAlertRequest request){
        QueryAlertResponse response = new QueryAlertResponse();
        try {
            if(request.getPageSize() == null){
                throw new BusinessException(ResponseStatus.Invalid.getCode(), "pageSize 为 null");
            }else if(request.getCurrPageNo() == null){
                throw new BusinessException(ResponseStatus.Invalid.getCode(), "pageNo 为 null");
            }
            User user = userMapper.selectByPrimaryKey(request.getAccessKey());
            PageHelper.startPage(request.getCurrPageNo(), request.getPageSize());
            AlertExample alertExample = new AlertExample();
            AlertExample.Criteria criteria = alertExample.createCriteria();
            criteria.andUserIdEqualTo(request.getAccessKey());
            alertExample.setOrderByClause("alert_time desc");
            List<Alert> alerts= alertMapper.selectByExample(alertExample);
            PageInfo<Alert> pageInfo = new PageInfo<Alert>(alerts);
            List<AlertVo>  alertVos = new ArrayList<AlertVo>();
            for (Alert alert : alerts){
                AlertVo vo = new AlertVo();
                BeanUtils.copyProperties(alert, vo);
                Room room = roomMapper.selectByPrimaryKey(alert.getRoomId());
                RoomVo roomVo = roomController.getRoomVo(room);
                vo.setRoom(roomVo);
                alertVos.add(vo);
                StringBuilder sb = new StringBuilder();
               Double threshold = null;
                switch (alert.getAlertType()){
                    case 1:
                        threshold = room.getTemperatureThreshold();
                    case 2:
                        threshold = room.getHumidityThreshold();
                    case 3:
                        threshold = room.getSmokeConcentration();
                }
                //您的“”在“” “” 超过 阈值“” 产生报警，报警值为“”)
                sb.append("您的")
                .append(Constants.ROOM_TYPE_NAME[room.getRoomType()])
                        .append("在")
                        .append(alert.getAlertTime())
                        .append(Constants.ALERT_TYPE_NAME[alert.getAlertType()])
                        .append("超过阈值")
                        .append(threshold)
                        .append("产生报警，报警值为：")
                        .append(alert.getAlertValue());
                vo.setContent(sb.toString());

            }

            response.setResult(alertVos);
            response.setPagination(PageUtils.getPagination(pageInfo));
            response.setSuccess(true);
        }catch (BusinessException e){
            e.printStackTrace();
            response.setSuccess(false);
            response.setError(e.toString());
        }catch (Exception e){
            response.setSuccess(false);
            e.printStackTrace();
            response.setError(e.toString());
        }
        return  response;
    }

}
