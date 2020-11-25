package com.tedu.blog.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * comment
 * @author 
 */
public class Comment2 implements Serializable {
    private Integer cId;

    private Integer userId;

    private Integer essayId;

    private Integer power;

    private String content;

    private Date createdTime;

    private Date updateTime;

    private List<User> userList;

    private static final long serialVersionUID = 1L;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEssayId() {
        return essayId;
    }

    public void setEssayId(Integer essayId) {
        this.essayId = essayId;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment2 comment2 = (Comment2) o;

        if (cId != null ? !cId.equals(comment2.cId) : comment2.cId != null) return false;
        if (userId != null ? !userId.equals(comment2.userId) : comment2.userId != null) return false;
        if (essayId != null ? !essayId.equals(comment2.essayId) : comment2.essayId != null) return false;
        if (power != null ? !power.equals(comment2.power) : comment2.power != null) return false;
        if (content != null ? !content.equals(comment2.content) : comment2.content != null) return false;
        if (createdTime != null ? !createdTime.equals(comment2.createdTime) : comment2.createdTime != null)
            return false;
        if (updateTime != null ? !updateTime.equals(comment2.updateTime) : comment2.updateTime != null) return false;
        return userList != null ? userList.equals(comment2.userList) : comment2.userList == null;
    }

    @Override
    public int hashCode() {
        int result = cId != null ? cId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (essayId != null ? essayId.hashCode() : 0);
        result = 31 * result + (power != null ? power.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (userList != null ? userList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Comment2{" +
                "cId=" + cId +
                ", userId=" + userId +
                ", essayId=" + essayId +
                ", power=" + power +
                ", content='" + content + '\'' +
                ", createdTime=" + createdTime +
                ", updateTime=" + updateTime +
                ", userList=" + userList +
                '}';
    }
}