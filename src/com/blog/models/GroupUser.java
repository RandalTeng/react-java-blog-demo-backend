package com.blog.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * com.blog.models
 *
 * @author Created by randal on 18-6-26.
 */
@Entity
@Table(name = "group_user")
public class GroupUser implements Serializable {
    @Id
    private Integer id;
    private Integer gid;
    private Integer uid;

    @ManyToOne(targetEntity = Group.class)
    @JoinColumn(name = "gid", insertable = false, updatable = false)
    private Group group;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "uid", insertable = false, updatable = false)
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
