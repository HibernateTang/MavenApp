package com.spring.oa.domain;

import javax.persistence.*;

/**
 * Created by burning-.- on 2015/7/2.
 */
@Entity
public class Fan {
    private int id;
    private Integer listenerId;
    private Integer hostId;
    private User userByListenerId;
    private User userByHostId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "listener_id")
    public Integer getListenerId() {
        return listenerId;
    }

    public void setListenerId(Integer listenerId) {
        this.listenerId = listenerId;
    }

    @Basic
    @Column(name = "host_id")
    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(Integer hostId) {
        this.hostId = hostId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Fan fan = (Fan) object;

        if (id != fan.id) return false;
        if (listenerId != null ? !listenerId.equals(fan.listenerId) : fan.listenerId != null) return false;
        if (hostId != null ? !hostId.equals(fan.hostId) : fan.hostId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (listenerId != null ? listenerId.hashCode() : 0);
        result = 31 * result + (hostId != null ? hostId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "listener_id", referencedColumnName = "id")
    public User getUserByListenerId() {
        return userByListenerId;
    }

    public void setUserByListenerId(User userByListenerId) {
        this.userByListenerId = userByListenerId;
    }

    @ManyToOne
    @JoinColumn(name = "host_id", referencedColumnName = "id")
    public User getUserByHostId() {
        return userByHostId;
    }

    public void setUserByHostId(User userByHostId) {
        this.userByHostId = userByHostId;
    }
}
