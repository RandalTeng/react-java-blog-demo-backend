package com.blog.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * com.blog.models
 *
 * @author Created by randal on 18-6-26.
 */
@Entity
@Table(name = "group")
public class Group implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "group_name")
    private String groupName;
    private Integer pid;
    private String path;
    private String description;

    @OneToMany(targetEntity = GroupUser.class, mappedBy = "group")
    private Set<GroupUser> groupUsers = new HashSet<GroupUser>();

    @ManyToMany(targetEntity = User.class, mappedBy = "groups")
    private Set<User> users = new HashSet<User>();
    @ManyToMany(targetEntity = Rule.class, mappedBy = "groups")
    private Set<Rule> rules = new HashSet<Rule>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<GroupUser> getGroupUsers() {
        return groupUsers;
    }

    public void setGroupUsers(Set<GroupUser> groupUsers) {
        this.groupUsers = groupUsers;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Rule> getRules() {
        return rules;
    }

    public void setRules(Set<Rule> rules) {
        this.rules = rules;
    }
}
