package com.kby.home.safety.model;

import java.io.Serializable;
import java.util.Date;

public class Alert implements Serializable {
    /**
     *  ,所属表字段为alert_history.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *  ,所属表字段为alert_history.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     *  ,所属表字段为alert_history.room_id
     *
     * @mbggenerated
     */
    private Integer roomId;

    /**
     *  ,所属表字段为alert_history.alert_type
     *
     * @mbggenerated
     */
    private Integer alertType;

    /**
     *  ,所属表字段为alert_history.alert_value
     *
     * @mbggenerated
     */
    private Double alertValue;

    /**
     *  ,所属表字段为alert_history.alert_time
     *
     * @mbggenerated
     */
    private Date alertTime;

    /**
     *  ,所属表字段为alert_history.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     *  ,所属表字段为alert_history.udpate_time
     *
     * @mbggenerated
     */
    private Date udpateTime;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUdpateTime() {
        return udpateTime;
    }

    public void setUdpateTime(Date udpateTime) {
        this.udpateTime = udpateTime;
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
        Alert other = (Alert) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
            && (this.getAlertType() == null ? other.getAlertType() == null : this.getAlertType().equals(other.getAlertType()))
            && (this.getAlertValue() == null ? other.getAlertValue() == null : this.getAlertValue().equals(other.getAlertValue()))
            && (this.getAlertTime() == null ? other.getAlertTime() == null : this.getAlertTime().equals(other.getAlertTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUdpateTime() == null ? other.getUdpateTime() == null : this.getUdpateTime().equals(other.getUdpateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        result = prime * result + ((getAlertType() == null) ? 0 : getAlertType().hashCode());
        result = prime * result + ((getAlertValue() == null) ? 0 : getAlertValue().hashCode());
        result = prime * result + ((getAlertTime() == null) ? 0 : getAlertTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUdpateTime() == null) ? 0 : getUdpateTime().hashCode());
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
        sb.append(", roomId=").append(roomId);
        sb.append(", alertType=").append(alertType);
        sb.append(", alertValue=").append(alertValue);
        sb.append(", alertTime=").append(alertTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", udpateTime=").append(udpateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}