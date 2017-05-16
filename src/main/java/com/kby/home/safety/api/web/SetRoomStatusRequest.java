package com.kby.home.safety.api.web;

/**
 * Created by zhangpeng12 on 2017/5/16.
 */
public class SetRoomStatusRequest {

    private Double temperature;


    private Double humidity;

    private Double smoke;

    private Integer roomType;

    private String username;

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getSmoke() {
        return smoke;
    }

    public void setSmoke(Double smoke) {
        this.smoke = smoke;
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
