package com.spring.oa.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by burning-.- on 2015/7/2.
 */
@Entity
public class Video {
    private int id;
    private Integer channelId;
    private Integer userId;
    private String clientFileName;
    private String serverFileName;
    private String pcFileName;
    private String title;
    private String tags;
    private String description;
    private Integer playCount;
    private Integer commentCount;
    private Integer goodCommentCount;
    private Integer badCommentCount;
    private Integer duration;
    private Timestamp uploadTime;
    private String status;
    private Collection<Comment> commentsById;
    private Channel channelByChannelId;
    private User userByUserId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "channel_id")
    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "Client_file_name")
    public String getClientFileName() {
        return clientFileName;
    }

    public void setClientFileName(String clientFileName) {
        this.clientFileName = clientFileName;
    }

    @Basic
    @Column(name = "server_file_name")
    public String getServerFileName() {
        return serverFileName;
    }

    public void setServerFileName(String serverFileName) {
        this.serverFileName = serverFileName;
    }

    @Basic
    @Column(name = "pc_file_name")
    public String getPcFileName() {
        return pcFileName;
    }

    public void setPcFileName(String pcFileName) {
        this.pcFileName = pcFileName;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "tags")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "play_count")
    public Integer getPlayCount() {
        return playCount;
    }

    public void setPlayCount(Integer playCount) {
        this.playCount = playCount;
    }

    @Basic
    @Column(name = "comment_count")
    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @Basic
    @Column(name = "good_comment_count")
    public Integer getGoodCommentCount() {
        return goodCommentCount;
    }

    public void setGoodCommentCount(Integer goodCommentCount) {
        this.goodCommentCount = goodCommentCount;
    }

    @Basic
    @Column(name = "bad_comment_count")
    public Integer getBadCommentCount() {
        return badCommentCount;
    }

    public void setBadCommentCount(Integer badCommentCount) {
        this.badCommentCount = badCommentCount;
    }

    @Basic
    @Column(name = "duration")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "upload_time")
    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Video video = (Video) object;

        if (id != video.id) return false;
        if (channelId != null ? !channelId.equals(video.channelId) : video.channelId != null) return false;
        if (userId != null ? !userId.equals(video.userId) : video.userId != null) return false;
        if (clientFileName != null ? !clientFileName.equals(video.clientFileName) : video.clientFileName != null)
            return false;
        if (serverFileName != null ? !serverFileName.equals(video.serverFileName) : video.serverFileName != null)
            return false;
        if (pcFileName != null ? !pcFileName.equals(video.pcFileName) : video.pcFileName != null) return false;
        if (title != null ? !title.equals(video.title) : video.title != null) return false;
        if (tags != null ? !tags.equals(video.tags) : video.tags != null) return false;
        if (description != null ? !description.equals(video.description) : video.description != null) return false;
        if (playCount != null ? !playCount.equals(video.playCount) : video.playCount != null) return false;
        if (commentCount != null ? !commentCount.equals(video.commentCount) : video.commentCount != null) return false;
        if (goodCommentCount != null ? !goodCommentCount.equals(video.goodCommentCount) : video.goodCommentCount != null)
            return false;
        if (badCommentCount != null ? !badCommentCount.equals(video.badCommentCount) : video.badCommentCount != null)
            return false;
        if (duration != null ? !duration.equals(video.duration) : video.duration != null) return false;
        if (uploadTime != null ? !uploadTime.equals(video.uploadTime) : video.uploadTime != null) return false;
        if (status != null ? !status.equals(video.status) : video.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (channelId != null ? channelId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (clientFileName != null ? clientFileName.hashCode() : 0);
        result = 31 * result + (serverFileName != null ? serverFileName.hashCode() : 0);
        result = 31 * result + (pcFileName != null ? pcFileName.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (playCount != null ? playCount.hashCode() : 0);
        result = 31 * result + (commentCount != null ? commentCount.hashCode() : 0);
        result = 31 * result + (goodCommentCount != null ? goodCommentCount.hashCode() : 0);
        result = 31 * result + (badCommentCount != null ? badCommentCount.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (uploadTime != null ? uploadTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "videoByVideoId")
    public Collection<Comment> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(Collection<Comment> commentsById) {
        this.commentsById = commentsById;
    }

    @ManyToOne
    @JoinColumn(name = "channel_id", referencedColumnName = "id")
    public Channel getChannelByChannelId() {
        return channelByChannelId;
    }

    public void setChannelByChannelId(Channel channelByChannelId) {
        this.channelByChannelId = channelByChannelId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}
