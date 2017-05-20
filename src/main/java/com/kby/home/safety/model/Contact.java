package com.kby.home.safety.model;

import java.io.Serializable;
import java.util.Date;

public class Contact implements Serializable {
    /**
     *  ,鎵�睘琛ㄥ瓧娈典负user_contacts.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *  用户id,鎵�睘琛ㄥ瓧娈典负user_contacts.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     *  联系人姓名,鎵�睘琛ㄥ瓧娈典负user_contacts.contact_name
     *
     * @mbggenerated
     */
    private String contactName;

    /**
     *  l联系人性别,鎵�睘琛ㄥ瓧娈典负user_contacts.sex
     *
     * @mbggenerated
     */
    private Byte sex;

    /**
     *  l联系人电话号码,鎵�睘琛ㄥ瓧娈典负user_contacts.phone_number
     *
     * @mbggenerated
     */
    private String phoneNumber;

    /**
     *  l联系人住址,鎵�睘琛ㄥ瓧娈典负user_contacts.address
     *
     * @mbggenerated
     */
    private String address;

    /**
     *  联系人邮箱,鎵�睘琛ㄥ瓧娈典负user_contacts.email
     *
     * @mbggenerated
     */
    private String email;

    /**
     *  联系人状态,鎵�睘琛ㄥ瓧娈典负user_contacts.state
     *
     * @mbggenerated
     */
    private Integer state;

    /**
     *  记录创建时间,鎵�睘琛ㄥ瓧娈典负user_contacts.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     *  记录修改时间,鎵�睘琛ㄥ瓧娈典负user_contacts.update_time
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

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
        Contact other = (Contact) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getContactName() == null ? other.getContactName() == null : this.getContactName().equals(other.getContactName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getContactName() == null) ? 0 : getContactName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
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
        sb.append(", contactName=").append(contactName);
        sb.append(", sex=").append(sex);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", address=").append(address);
        sb.append(", email=").append(email);
        sb.append(", state=").append(state);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}