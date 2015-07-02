package com.spring.oa.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by burning-.- on 2015/7/2.
 */
@Entity
public class Face {
    private int id;
    private String picFileName;
    private Collection<User> usersById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "pic_file_name")
    public String getPicFileName() {
        return picFileName;
    }

    public void setPicFileName(String picFileName) {
        this.picFileName = picFileName;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Face face = (Face) object;

        if (id != face.id) return false;
        if (picFileName != null ? !picFileName.equals(face.picFileName) : face.picFileName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (picFileName != null ? picFileName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "faceByFacePicId")
    public Collection<User> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<User> usersById) {
        this.usersById = usersById;
    }
}
