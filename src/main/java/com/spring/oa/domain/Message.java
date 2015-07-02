package com.spring.oa.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by burning-.- on 2015/7/2.
 */
@Entity
public class Message {
    private int id;
    private Integer senderId;
    private Integer receiverId;
    private String content;
    private Timestamp time;
    private User userBySenderId;
    private User userByReceiverId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sender_id")
    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    @Basic
    @Column(name = "receiver_id")
    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
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

        Message message = (Message) object;

        if (id != message.id) return false;
        if (senderId != null ? !senderId.equals(message.senderId) : message.senderId != null) return false;
        if (receiverId != null ? !receiverId.equals(message.receiverId) : message.receiverId != null) return false;
        if (content != null ? !content.equals(message.content) : message.content != null) return false;
        if (time != null ? !time.equals(message.time) : message.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (senderId != null ? senderId.hashCode() : 0);
        result = 31 * result + (receiverId != null ? receiverId.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    public User getUserBySenderId() {
        return userBySenderId;
    }

    public void setUserBySenderId(User userBySenderId) {
        this.userBySenderId = userBySenderId;
    }

    @ManyToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "id")
    public User getUserByReceiverId() {
        return userByReceiverId;
    }

    public void setUserByReceiverId(User userByReceiverId) {
        this.userByReceiverId = userByReceiverId;
    }
}
