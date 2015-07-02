package com.spring.oa.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by burning-.- on 2015/7/2.
 */
@Entity
public class Comment {
    private int id;
    private Integer userId;
    private Integer videoId;
    private String content;
    private Timestamp time;
    private User userByUserId;
    private Video videoByVideoId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "User_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "Video_id")
    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "Time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Comment comment = (Comment) object;

        if (id != comment.id) return false;
        if (userId != null ? !userId.equals(comment.userId) : comment.userId != null) return false;
        if (videoId != null ? !videoId.equals(comment.videoId) : comment.videoId != null) return false;
        if (content != null ? !content.equals(comment.content) : comment.content != null) return false;
        if (time != null ? !time.equals(comment.time) : comment.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (videoId != null ? videoId.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "User_id", referencedColumnName = "id")
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "Video_id", referencedColumnName = "id")
    public Video getVideoByVideoId() {
        return videoByVideoId;
    }

    public void setVideoByVideoId(Video videoByVideoId) {
        this.videoByVideoId = videoByVideoId;
    }
}
