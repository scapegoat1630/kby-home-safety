package com.kby.home.safety.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kby.home.safety.api.exception.BusinessException;
import com.kby.home.safety.api.web.*;
import com.kby.home.safety.mapper.AlertMapper;
import com.kby.home.safety.mapper.RoomMapper;
import com.kby.home.safety.mapper.UserMapper;
import com.kby.home.safety.model.Alert;
import com.kby.home.safety.model.AlertExample;
import com.kby.home.safety.model.User;
import com.kby.home.safety.util.PageUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;


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

    /**
     * 查找最新的报警规则,安卓端不断查询这个口
     * @param request
     * @return
     */
    @RequestMapping("/queryAlarming")
    @ResponseBody
    @Transactional
    public Response queryAlert(@RequestBody QueryAlarmingRequest request){
        Response response = new Response();
        try {
            User user = userMapper.selectByPrimaryKey(request.getAccessKey());
            AlertExample alertExample = new AlertExample();
            AlertExample.Criteria criteria = alertExample.createCriteria();
            criteria.andUserIdEqualTo(request.getAccessKey());
            criteria.andIsLatestEqualTo(1);
            alertExample.setOrderByClause("alert_time desc");
            List<Alert> alerts= alertMapper.selectByExample(alertExample);
            response.setResult(alerts);
            response.setSuccess(true);
            //---------------------跟新状态-----------------
           for(Alert alert : alerts){
                alert.setIsLatest(0);
               alert.setUdpateTime(new Date());
               alertMapper.updateByPrimaryKey(alert);
           }
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

    @RequestMapping("/queryAlert")
    @ResponseBody
    @Transactional
    public Response queryAlert(@RequestBody QueryAlertRequest request){
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
            if(StringUtils.isNotEmpty(request.getContent())){
                criteria.andContentLike(request.getContent());
            }
            alertExample.setOrderByClause("alert_time desc");
            List<Alert> alerts= alertMapper.selectByExample(alertExample);
            PageInfo<Alert> pageInfo = new PageInfo<Alert>(alerts);
            response.setResult(alerts);
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

    /**
     * 删除报警
     * @param request
     * @return
     */
    @RequestMapping("/deleteAlert")
    @ResponseBody
    @Transactional
    public Response deleteAlert(@RequestBody DeleteAlertRequest request){
        Response response = new Response();
        try {
            User user = userMapper.selectByPrimaryKey(request.getAccessKey());
            if(user == null){
                throw new BusinessException(ResponseStatus.Invalid.getCode(), "您未登陆，请登录");
            }
            AlertExample alertExample = new AlertExample();
            AlertExample.Criteria criteria = alertExample.createCriteria();
            criteria.andUserIdEqualTo(request.getAccessKey());
            criteria.andIdIn(request.getIds());
            alertMapper.deleteByExample(alertExample);
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

    /**
     * 标记报警
     * @param request
     * @return
     */
    @RequestMapping("/markAlert")
    @ResponseBody
    @Transactional
    public Response markAlert(@RequestBody DeleteAlertRequest request){
        Response response = new Response();
        try {
            User user = userMapper.selectByPrimaryKey(request.getAccessKey());
            if(user == null){
                throw new BusinessException(ResponseStatus.Invalid.getCode(), "您未登陆，请登录");
            }
            AlertExample alertExample = new AlertExample();
            AlertExample.Criteria criteria = alertExample.createCriteria();
            criteria.andUserIdEqualTo(request.getAccessKey());
            criteria.andIdIn(request.getIds());
            Alert alert = new Alert();
            alert.setMark(1);
            alertMapper.updateByExampleSelective(alert, alertExample);
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
