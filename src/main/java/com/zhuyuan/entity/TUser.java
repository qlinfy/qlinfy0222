package com.zhuyuan.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by Administrator on 2017/3/2.
 */
@Entity
@Table(name = "t_user", schema = "qlinfy20160802", catalog = "")
public class TUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @NotEmpty(message = "用户名不能为空")
    private String userName;
    @NotEmpty(message = "密码不能为空")
    private String password;
    private Date createdTime;
    private Date updateTime;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "t_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_id") })
    private List<TRole> roleList;// 一个用户具有多个角色

    public List<TRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<TRole> roleList) {
        this.roleList = roleList;
    }

    @Transient
    public Set<String> getRolesName() {
        List<TRole> roles = getRoleList();
        Set<String> set = new HashSet<String>();
        for (TRole role : roles) {
            set.add(role.getRoleName());
        }
        return set;
    }

    public TUser(){}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }


    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


}
