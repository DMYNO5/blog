package com.tedu.blog.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * dataanalysis
 * @author 
 */
public class Dataanalysis implements Serializable {
    private Integer dataId;

    private Date whereisday;

    private Integer userCount;

    private Integer commentCount;

    private Integer collectionCount;

    private Integer essayCount;

    private static final long serialVersionUID = 1L;

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public Date getWhereisday() {
        return whereisday;
    }

    public void setWhereisday(Date whereisday) {
        this.whereisday = whereisday;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getCollectionCount() {
        return collectionCount;
    }

    public void setCollectionCount(Integer collectionCount) {
        this.collectionCount = collectionCount;
    }

    public Integer getEssayCount() {
        return essayCount;
    }

    public void setEssayCount(Integer essayCount) {
        this.essayCount = essayCount;
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
        Dataanalysis other = (Dataanalysis) that;
        return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getWhereisday() == null ? other.getWhereisday() == null : this.getWhereisday().equals(other.getWhereisday()))
            && (this.getUserCount() == null ? other.getUserCount() == null : this.getUserCount().equals(other.getUserCount()))
            && (this.getCommentCount() == null ? other.getCommentCount() == null : this.getCommentCount().equals(other.getCommentCount()))
            && (this.getCollectionCount() == null ? other.getCollectionCount() == null : this.getCollectionCount().equals(other.getCollectionCount()))
            && (this.getEssayCount() == null ? other.getEssayCount() == null : this.getEssayCount().equals(other.getEssayCount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getWhereisday() == null) ? 0 : getWhereisday().hashCode());
        result = prime * result + ((getUserCount() == null) ? 0 : getUserCount().hashCode());
        result = prime * result + ((getCommentCount() == null) ? 0 : getCommentCount().hashCode());
        result = prime * result + ((getCollectionCount() == null) ? 0 : getCollectionCount().hashCode());
        result = prime * result + ((getEssayCount() == null) ? 0 : getEssayCount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", whereisday=").append(whereisday);
        sb.append(", userCount=").append(userCount);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", collectionCount=").append(collectionCount);
        sb.append(", essayCount=").append(essayCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}