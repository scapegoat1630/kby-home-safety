package com.kby.home.safety.model;

import java.io.Serializable;
import java.util.Date;

public class RoomMonitor implements Serializable {
    /**
     *  ,鎵�睘琛ㄥ瓧娈典负room_monitor.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *  room类型,鎵�睘琛ㄥ瓧娈典负room_monitor.room_id
     *
     * @mbggenerated
     */
    private Integer roomId;

    /**
     *  监控值,鎵�睘琛ㄥ瓧娈典负room_monitor.temperature
     *
     * @mbggenerated
     */
    private Double temperature;

    /**
     *  ,鎵�睘琛ㄥ瓧娈典负room_monitor.humidity
     *
     * @mbggenerated
     */
    private Double humidity;

    /**
     *  ,鎵�睘琛ㄥ瓧娈典负room_monitor.smoke
     *
     * @mbggenerated
     */
    private Double smoke;

    /**
     *  ,鎵�睘琛ㄥ瓧娈典负room_monitor.is_latest
     *
     * @mbggenerated
     */
    private Integer isLatest;

    /**
     *  记录产生时间,鎵�睘琛ㄥ瓧娈典负room_monitor.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     *  记录修改时间,鎵�睘琛ㄥ瓧娈典负room_monitor.update_time
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

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
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

    public Integer getIsLatest() {
        return isLatest;
    }

    public void setIsLatest(Integer isLatest) {
        this.isLatest = isLatest;
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
        RoomMonitor other = (RoomMonitor) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
            && (this.getTemperature() == null ? other.getTemperature() == null : this.getTemperature().equals(other.getTemperature()))
            && (this.getHumidity() == null ? other.getHumidity() == null : this.getHumidity().equals(other.getHumidity()))
            && (this.getSmoke() == null ? other.getSmoke() == null : this.getSmoke().equals(other.getSmoke()))
            && (this.getIsLatest() == null ? other.getIsLatest() == null : this.getIsLatest().equals(other.getIsLatest()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        result = prime * result + ((getTemperature() == null) ? 0 : getTemperature().hashCode());
        result = prime * result + ((getHumidity() == null) ? 0 : getHumidity().hashCode());
        result = prime * result + ((getSmoke() == null) ? 0 : getSmoke().hashCode());
        result = prime * result + ((getIsLatest() == null) ? 0 : getIsLatest().hashCode());
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
        sb.append(", roomId=").append(roomId);
        sb.append(", temperature=").append(temperature);
        sb.append(", humidity=").append(humidity);
        sb.append(", smoke=").append(smoke);
        sb.append(", isLatest=").append(isLatest);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}