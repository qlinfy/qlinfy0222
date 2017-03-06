package com.zhuyuan.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/3/2.
 */
@Entity
@Table(name = "t_role", schema = "qlinfy20160802", catalog = "")
public class TRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    private String roleName;
    private Date createdTime;
    private Date updateTime;

    @ManyToMany
    @JoinTable(name = "t_role_permission", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {
            @JoinColumn(name = "permission_id") })
    private List<TPermission> permissionList;// 一个角色对应多个权限
    @ManyToMany
    @JoinTable(name = "t_user_role", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {
            @JoinColumn(name = "user_id") })
    private List<TUser> userList;// 一个角色对应多个用户

    public List<TPermission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<TPermission> permissionList) {
        this.permissionList = permissionList;
    }

    // 省略 get set 方法

    @Transient
    public List<String> getPermissionsName() {
        List<String> list = new ArrayList<String>();
        List<TPermission> perlist = getPermissionList();
        for (TPermission per : perlist) {
            list.add(per.getPermissionName());
        }
        return list;
    }


    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
