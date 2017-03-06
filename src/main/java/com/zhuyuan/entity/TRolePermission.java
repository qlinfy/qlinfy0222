package com.zhuyuan.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/3/2.
 */
@Entity
@Table(name = "t_role_permission", schema = "qlinfy20160802", catalog = "")
public class TRolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int roleId;

    private int permissionId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }
}
