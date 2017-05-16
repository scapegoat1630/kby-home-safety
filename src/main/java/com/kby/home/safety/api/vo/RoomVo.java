package com.kby.home.safety.api.vo;

import java.io.Serializable;

/**
 * Created by zhangpeng12 on 2017/5/15.
 */
public class RoomVo implements Serializable{


    private Integer roomId;

    private Integer userId;

    private Integer roomType;

    private Double temperature;

    private String temperatureStatus;

    private Double humidity;

    private String humidityStatus;

    private Double smoke;

    private String smokeStatus;

    private Double temperatureThreshold;

    private Double humidityThreshold;

    private Double smokeConcentration;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

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

    public Double getTemperatureThreshold() {
        return temperatureThreshold;
    }

    public void setTemperatureThreshold(Double temperatureThreshold) {
        this.temperatureThreshold = temperatureThreshold;
    }

    public Double getHumidityThreshold() {
        return humidityThreshold;
    }

    public void setHumidityThreshold(Double humidityThreshold) {
        this.humidityThreshold = humidityThreshold;
    }

    public Double getSmokeConcentration() {
        return smokeConcentration;
    }

    public void setSmokeConcentration(Double smokeConcentration) {
        this.smokeConcentration = smokeConcentration;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RoomVo{");
        sb.append("roomId=").append(roomId);
        sb.append(", userId=").append(userId);
        sb.append(", roomType=").append(roomType);
        sb.append(", temperature=").append(temperature);
        sb.append(", humidity=").append(humidity);
        sb.append(", smoke=").append(smoke);
        sb.append(", temperatureThreshold=").append(temperatureThreshold);
        sb.append(", humidityThreshold=").append(humidityThreshold);
        sb.append(", smokeConcentration=").append(smokeConcentration);
        sb.append('}');
        return sb.toString();
    }

    public String getTemperatureStatus() {
        return temperatureStatus;
    }

    public void setTemperatureStatus(String temperatureStatus) {
        this.temperatureStatus = temperatureStatus;
    }

    public String getHumidityStatus() {
        return humidityStatus;
    }

    public void setHumidityStatus(String humidityStatus) {
        this.humidityStatus = humidityStatus;
    }

    public String getSmokeStatus() {
        return smokeStatus;
    }

    public void setSmokeStatus(String smokeStatus) {
        this.smokeStatus = smokeStatus;
    }
}
