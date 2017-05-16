package com.kby.home.safety.api.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhangpeng12 on 2017/5/16.
 */
public class AlertVo implements Serializable{

    private Integer id;


    private Integer userId;


    private Integer roomId;


    private Integer alertType;


    private Double alertValue;


    private Date alertTime;

    private RoomVo room;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getAlertType() {
        return alertType;
    }

    public void setAlertType(Integer alertType) {
        this.alertType = alertType;
    }

    public Double getAlertValue() {
        return alertValue;
    }

    public void setAlertValue(Double alertValue) {
        this.alertValue = alertValue;
    }

    public Date getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(Date alertTime) {
        this.alertTime = alertTime;
    }

    public RoomVo getRoom() {
        return room;
    }

    public void setRoom(RoomVo room) {
        this.room = room;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
