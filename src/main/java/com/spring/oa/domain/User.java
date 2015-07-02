package com.spring.oa.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by burning-.- on 2015/7/2.
 */
@Entity
public class User {
    private int id;
    private String name;
    private String password;
    private Integer facePicId;
    private Timestamp lastLoginTime;
    private Integer visitCount;
    private Integer totalPlayCount;
    private Collection<Comment> commentsById;
    private Collection<Fan> fansById;
    private Collection<Fan> fansById_0;
    private Collection<Message> messagesById;
    private Collection<Message> messagesById_0;
    private Face faceByFacePicId;
    private Collection<Video> videosById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "face_pic_id")
    public Integer getFacePicId() {
        return facePicId;
    }

    public void setFacePicId(Integer facePicId) {
        this.facePicId = facePicId;
    }

    @Basic
    @Column(name = "last_login_time")
    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Basic
    @Column(name = "visit_count")
    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    @Basic
    @Column(name = "total_play_count")
    public Integer getTotalPlayCount() {
        return totalPlayCount;
    }

    public void setTotalPlayCount(Integer totalPlayCount) {
        this.totalPlayCount = totalPlayCount;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        User user = (User) object;

        if (id != user.id) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (facePicId != null ? !facePicId.equals(user.facePicId) : user.facePicId != null) return false;
        if (lastLoginTime != null ? !lastLoginTime.equals(user.lastLoginTime) : user.lastLoginTime != null)
            return false;
        if (visitCount != null ? !visitCount.equals(user.visitCount) : user.visitCount != null) return false;
        if (totalPlayCount != null ? !totalPlayCount.equals(user.totalPlayCount) : user.totalPlayCount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (facePicId != null ? facePicId.hashCode() : 0);
        result = 31 * result + (lastLoginTime != null ? lastLoginTime.hashCode() : 0);
        result = 31 * result + (visitCount != null ? visitCount.hashCode() : 0);
        result = 31 * result + (totalPlayCount != null ? totalPlayCount.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Comment> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(Collection<Comment> commentsById) {
        this.commentsById = commentsById;
    }

    @OneToMany(mappedBy = "userByListenerId")
    public Collection<Fan> getFansById() {
        return fansById;
    }

    public void setFansById(Collection<Fan> fansById) {
        this.fansById = fansById;
    }

    @OneToMany(mappedBy = "userByHostId")
    public Collection<Fan> getFansById_0() {
        return fansById_0;
    }

    public void setFansById_0(Collection<Fan> fansById_0) {
        this.fansById_0 = fansById_0;
    }

    @OneToMany(mappedBy = "userBySenderId")
    public Collection<Message> getMessagesById() {
        return messagesById;
    }

    public void setMessagesById(Collection<Message> messagesById) {
        this.messagesById = messagesById;
    }

    @OneToMany(mappedBy = "userByReceiverId")
    public Collection<Message> getMessagesById_0() {
        return messagesById_0;
    }

    public void setMessagesById_0(Collection<Message> messagesById_0) {
        this.messagesById_0 = messagesById_0;
    }

    @ManyToOne
    @JoinColumn(name = "face_pic_id", referencedColumnName = "id")
    public Face getFaceByFacePicId() {
        return faceByFacePicId;
    }

    public void setFaceByFacePicId(Face faceByFacePicId) {
        this.faceByFacePicId = faceByFacePicId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Video> getVideosById() {
        return videosById;
    }

    public void setVideosById(Collection<Video> videosById) {
        this.videosById = videosById;
    }
}
