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
@Table(name = "user")
public class User implements Serializable {

    @Id
    private Integer id;
    private String username;
    private String password;
    private String salt;
    @Column(name = "group_id")
    private String groupId;
    private String description;
    @Column(name = "session_id")
    private String sessionId;
    @Column(name = "last_connect_uri")
    private String lastConnectUri;
    @Column(name = "last_connect_time")
    private String lastConnectTime;
    @Column(name = "last_connect_ip")
    private String lastConnectIp;

    @OneToMany(targetEntity = GroupUser.class, mappedBy = "user")
    private Set<GroupUser> groupUsers = new HashSet<GroupUser>();

    @ManyToMany(targetEntity = Group.class)
    @JoinTable(
            name = "group_user",
            joinColumns = @JoinColumn(name = "uid"),
            inverseJoinColumns = @JoinColumn(name = "gid")
    )
    private Set<Group> groups = new HashSet<Group>();

    @Override
    public String toString() {
        return getClass().getName() + "@" +
                "ID:" + id + "," +
                "username:" + username + "," +
                "description:" + description + ".\n";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getLastConnectUri() {
        return lastConnectUri;
    }

    public void setLastConnectUri(String lastConnectUri) {
        this.lastConnectUri = lastConnectUri;
    }

    public String getLastConnectTime() {
        return lastConnectTime;
    }

    public void setLastConnectTime(String lastConnectTime) {
        this.lastConnectTime = lastConnectTime;
    }

    public String getLastConnectIp() {
        return lastConnectIp;
    }

    public void setLastConnectIp(String lastConnectIp) {
        this.lastConnectIp = lastConnectIp;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Set<GroupUser> getGroupUsers() {
        return groupUsers;
    }

    public void setGroupUsers(Set<GroupUser> groupUsers) {
        this.groupUsers = groupUsers;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
