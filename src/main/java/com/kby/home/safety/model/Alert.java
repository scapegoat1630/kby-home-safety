package com.kby.home.safety.model;

import java.io.Serializable;
import java.util.Date;

public class Alert implements Serializable {
    /**
     *  ,鎵�睘琛ㄥ瓧娈典负alert_history.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *  ,鎵�睘琛ㄥ瓧娈典负alert_history.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     *  ,鎵�睘琛ㄥ瓧娈典负alert_history.room_id
     *
     * @mbggenerated
     */
    private Integer roomId;

    /**
     *  报警的类型：,鎵�睘琛ㄥ瓧娈典负alert_history.alert_type
     *
     * @mbggenerated
     */
    private Integer alertType;

    /**
     *  ,鎵�睘琛ㄥ瓧娈典负alert_history.alert_value
     *
     * @mbggenerated
     */
    private Double alertValue;

    /**
     *  ,鎵�睘琛ㄥ瓧娈典负alert_history.alert_time
     *
     * @mbggenerated
     */
    private Date alertTime;

    /**
     *  ,鎵�睘琛ㄥ瓧娈典负alert_history.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     *  ,鎵�睘琛ㄥ瓧娈典负alert_history.udpate_time
     *
     * @mbggenerated
     */
    private Date udpateTime;

    /**
     *  报警内容,鎵�睘琛ㄥ瓧娈典负alert_history.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     *  用户是否已经阅读,鎵�睘琛ㄥ瓧娈典负alert_history.is_latest
     *
     * @mbggenerated
     */
    private Integer isLatest;

    /**
     *  标记,鎵�睘琛ㄥ瓧娈典负alert_history.mark
     *
     * @mbggenerated
     */
    private Integer mark;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsLatest() {
        return isLatest;
    }

    public void setIsLatest(Integer isLatest) {
        this.isLatest = isLatest;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
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
            && (this.getUdpateTime() == null ? other.getUdpateTime() == null : this.getUdpateTime().equals(other.getUdpateTime()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getIsLatest() == null ? other.getIsLatest() == null : this.getIsLatest().equals(other.getIsLatest()))
            && (this.getMark() == null ? other.getMark() == null : this.getMark().equals(other.getMark()));
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
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getIsLatest() == null) ? 0 : getIsLatest().hashCode());
        result = prime * result + ((getMark() == null) ? 0 : getMark().hashCode());
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
        sb.append(", content=").append(content);
        sb.append(", isLatest=").append(isLatest);
        sb.append(", mark=").append(mark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}