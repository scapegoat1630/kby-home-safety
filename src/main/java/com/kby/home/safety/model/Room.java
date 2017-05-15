package com.kby.home.safety.model;

import java.io.Serializable;
import java.util.Date;

public class Room implements Serializable {
    /**
     *  自增id,所属表字段为user_room.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *  用户id,所属表字段为user_room.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     *  房间类型：{1：客厅，2：厨房，3：卧室},所属表字段为user_room.room_type
     *
     * @mbggenerated
     */
    private Boolean roomType;

    /**
     *  温度阈值,所属表字段为user_room.temperature_threshold
     *
     * @mbggenerated
     */
    private Double temperatureThreshold;

    /**
     *  湿度阈值,所属表字段为user_room.humidity_threshold
     *
     * @mbggenerated
     */
    private Double humidityThreshold;

    /**
     *  烟雾浓度阈值,所属表字段为user_room.smoke_concentration
     *
     * @mbggenerated
     */
    private Double smokeConcentration;

    /**
     *  记录创建时间,所属表字段为user_room.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     *  记录修改时间,所属表字段为user_room.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

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

    public Boolean getRoomType() {
        return roomType;
    }

    public void setRoomType(Boolean roomType) {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Room other = (Room) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRoomType() == null ? other.getRoomType() == null : this.getRoomType().equals(other.getRoomType()))
            && (this.getTemperatureThreshold() == null ? other.getTemperatureThreshold() == null : this.getTemperatureThreshold().equals(other.getTemperatureThreshold()))
            && (this.getHumidityThreshold() == null ? other.getHumidityThreshold() == null : this.getHumidityThreshold().equals(other.getHumidityThreshold()))
            && (this.getSmokeConcentration() == null ? other.getSmokeConcentration() == null : this.getSmokeConcentration().equals(other.getSmokeConcentration()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRoomType() == null) ? 0 : getRoomType().hashCode());
        result = prime * result + ((getTemperatureThreshold() == null) ? 0 : getTemperatureThreshold().hashCode());
        result = prime * result + ((getHumidityThreshold() == null) ? 0 : getHumidityThreshold().hashCode());
        result = prime * result + ((getSmokeConcentration() == null) ? 0 : getSmokeConcentration().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", roomType=").append(roomType);
        sb.append(", temperatureThreshold=").append(temperatureThreshold);
        sb.append(", humidityThreshold=").append(humidityThreshold);
        sb.append(", smokeConcentration=").append(smokeConcentration);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}