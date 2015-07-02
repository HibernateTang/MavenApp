package com.spring.oa.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by burning-.- on 2015/7/2.
 */
@Entity
public class Channel {
    private int id;
    private String name;
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Channel channel = (Channel) object;

        if (id != channel.id) return false;
        if (name != null ? !name.equals(channel.name) : channel.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "channelByChannelId")
    public Collection<Video> getVideosById() {
        return videosById;
    }

    public void setVideosById(Collection<Video> videosById) {
        this.videosById = videosById;
    }
}
