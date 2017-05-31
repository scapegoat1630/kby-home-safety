package com.kby.home.safety.controller;

import com.kby.home.safety.Constants;
import com.kby.home.safety.api.exception.BusinessException;
import com.kby.home.safety.api.vo.UserVo;
import com.kby.home.safety.api.web.*;
import com.kby.home.safety.api.vo.BaseUser;
import com.kby.home.safety.mapper.RoomMapper;
import com.kby.home.safety.mapper.RoomMonitorMapper;
import com.kby.home.safety.mapper.UserMapper;
import com.kby.home.safety.model.Room;
import com.kby.home.safety.model.RoomMonitor;
import com.kby.home.safety.model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper  userMapper;
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private RoomMonitorMapper roomMonitorMapper;

    @RequestMapping("/login")
    @ResponseBody
    public Response login(@RequestBody UserLoginRequest request){
        UserLoginRespose response = new UserLoginRespose();
        try{
            //---------------参数检查------------------
            String error = null;
            String username = request.getUsername();
            String password = request.getPassword();
            if(StringUtils.isEmpty(username)){
                error = "用户名为空";
            }else if (StringUtils.isEmpty(password)){
                error = "密码为空";
            }
            if(error != null){
                throw new BusinessException(ResponseStatus.Invalid.getCode(), error);
            }
            //-----------------------------------------
            User user = userMapper.login(username,password);
            if(user == null){
                throw new BusinessException(ResponseStatus.Invalid.getCode(), "用户名或密码不正确");
            }
            String SHA1sign = DigestUtils.sha1Hex(user.getId().toString());
            response.setAccessKey(user.getId());
            response.setSignature(SHA1sign);
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

    @RequestMapping(value="/register",method = {RequestMethod.POST })
    @ResponseBody
    @Transactional
    public Response register(@RequestBody UserRegisterRequest request){
        BaseUser vo = request.getUser();
        Date registerTime = new Date();
        UserRegisterResponse response = new UserRegisterResponse();
        try{
            //---------------参数检查------------------
            String error = null;
            String userName = vo.getUsername();
            if(StringUtils.isEmpty(userName)){
                error = "用户名为空";
            }else if (StringUtils.isEmpty(vo.getPassword())){
                error = "密码为空";
            }else if (StringUtils.isEmpty(vo.getPasswordRepeat())){
                error = "重复密码为空";
            }else if (!StringUtils.equals(vo.getPassword(),vo.getPasswordRepeat())){
                error = "密码与重复密码不相等";
            }else if (StringUtils.isEmpty(vo.getAddress())){
                error = "住址为空";
            }else if (StringUtils.isEmpty(vo.getEmail())){
                error = "邮箱为空";
            }else if(StringUtils.isEmpty(vo.getPhoneNumber())){
                error = "联系电话为空";
            }
            if(error != null){
                throw new BusinessException(ResponseStatus.Invalid.getCode(), error);
            }
            //检查用户名是否已经存在
            int userNameCount = userMapper.checkUserNameCount(vo.getUsername());
            if(userNameCount >= 1){
                throw new BusinessException(ResponseStatus.Invalid.getCode(), "用户名已存在");
            }
            //-----------------------------------------
            User user = new User();
            BeanUtils.copyProperties(vo, user);
            user.setId(null);
            user.setCreateTime(registerTime);
            user.setUpdateTime(registerTime);
            user.setState(1);
            userMapper.insert(user);
           //-----------------初始化三个房间--------------
            List<Room> roomList = new ArrayList<Room>();
            Room  kitchen = new Room(Constants.ROOM_TYPE_KITCHEN);//厨房
            roomList.add(kitchen);
            Room livingRoom = new Room(Constants.ROOM_TYPE_LIVINGROOM);//客厅
            roomList.add(livingRoom);
            Room bedRoom = new Room(Constants.ROOM_TYPE_BEDROOM);//卧室
            roomList.add(bedRoom);
            for(Room room : roomList){
                room.setUserId(user.getId());
                room.setCreateTime(registerTime);
                room.setUpdateTime(registerTime);
                room.setHumidityThreshold(25d);//湿度默认值
                room.setSmokeConcentration(0.65d);//烟雾浓度默认值
                room.setTemperatureThreshold(25d);//温度默认值
            }
            roomMapper.batchInsert(roomList);
            //---------------------初始化三个房间的状态------------
            RoomMonitor monitor = null;
            for(Room room : roomList){
                monitor = new RoomMonitor();
                monitor.setRoomId(room.getId());
                monitor.setCreateTime(registerTime);
                monitor.setUpdateTime(registerTime);
                monitor.setHumidity(25d);//湿度默认值
                monitor.setSmoke(25d);//烟雾浓度默认值
                monitor.setTemperature(25d);//温度默认值
                monitor.setIsLatest(1);
                roomMonitorMapper.insert(monitor);
            }
        }catch (BusinessException e){
            response.setSuccess(false);
            response.setError(e.getMessage());
            return response;
        }catch (Exception e){
            response.setSuccess(false);
            response.setError(e.getMessage());
            return response;
        }
        response.setSuccess(true);
        return response;
    }
    @RequestMapping("/queryUserInformation")
    @ResponseBody
    @Transactional
    public Response querUserInformation( @RequestBody Request request){
        User user = userMapper.selectByPrimaryKey(request.getAccessKey());
        Response<UserVo> response = new Response<UserVo>();
        UserVo vo = new UserVo();
        BeanUtils.copyProperties(user,vo);
        response.setSuccess(true);
        response.setResult(vo);
        return response;
    }

    @RequestMapping("/updateUserInformation")
    @ResponseBody
    @Transactional
    public Response updateUserInformation(@RequestBody UpdateUserRequest request){

        User user = userMapper.selectByPrimaryKey(request.getAccessKey());
        BaseUser baseUser = request.getUser();
        if (StringUtils.isNotEmpty(baseUser.getAddress())){
           user.setAddress(baseUser.getAddress());
        }
        if (StringUtils.isNotEmpty(baseUser.getEmail())){
            user.setEmail(baseUser.getEmail());
        }
        if(StringUtils.isNotEmpty(baseUser.getPhoneNumber())){
            user.setPhoneNumber(baseUser.getPhoneNumber());
        }
        user.setUpdateTime(new Date());
        userMapper.updateByPrimaryKey(user);
        Response<UserVo> response = new Response<UserVo>();
        UserVo vo = new UserVo();
        BeanUtils.copyProperties(user, vo);
        response.setResult(vo);
        response.setSuccess(true);
        return response;
    }
    @RequestMapping("/updateUserPassword")
    @ResponseBody
    @Transactional
    public Response updateUserPassword(@RequestBody UpdateUserPasswordRequest request){

        User user = userMapper.selectByPrimaryKey(request.getAccessKey());
        Response response = new Response();
        String error = null;
        try{
            if (StringUtils.isEmpty(request.getPassword())){
                error = "密码为空";
            }else if (StringUtils.isEmpty(request.getPasswordRepeat())){
                error = "重复密码为空";
            }else if (!StringUtils.equals(request.getPassword(),request.getPasswordRepeat())) {
                error = "密码与重复密码不相等";
            }
            if(error != null){
                throw new BusinessException(ResponseStatus.Invalid.getCode(), error);
            }
            user.setPassword(request.getPassword());
            user.setUpdateTime(new Date());
            userMapper.updateByPrimaryKey(user);
        }catch (BusinessException e){
            response.setSuccess(false);
            response.setError(e.getMessage());
            return response;
        }catch (Exception e){
            response.setSuccess(false);
            response.setError(e.getMessage());
            return response;
        }
        UserVo vo = new UserVo();
        BeanUtils.copyProperties(user, vo);
        response.setResult(vo);
        return response;
    }

    @RequestMapping("/uploadUserImage")
    @ResponseBody
    @Transactional
    public Response uploadUserImage(HttpServletRequest request){
        Response response = new Response();

        try{
            MultipartHttpServletRequest filerequest = (MultipartHttpServletRequest)request;
            MultipartFile file = (MultipartFile)filerequest.getFile("imagePath");
            String path = request.getSession().getServletContext().getRealPath("resources/upload");
            String imageName = request.getParameter("accessKey");
            String fileName = file.getOriginalFilename();
            File targetFile = new File(path, imageName + ".jpg");
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }
            file.transferTo(targetFile);
            response.setSuccess(true);
        }catch (BusinessException e){
            response.setSuccess(false);
            response.setError(e.getMessage());
        }catch (Exception e){
            response.setSuccess(false);
            response.setError(e.getMessage());

        }
        return response;
    }
    @RequestMapping("/upload")
    public String setRoomStatusPage(){
        return "fileupload";
    }
}
