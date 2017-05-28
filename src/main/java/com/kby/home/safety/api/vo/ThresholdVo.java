package com.kby.home.safety.api.vo;

/**
 * Created by zhangpeng12 on 2017/5/28.
 */
public class ThresholdVo {

    private Integer roomType;
    private Double temperatureThreshold;

    private Double humidityThreshold;

    private Double smokeConcentration;

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
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
}
