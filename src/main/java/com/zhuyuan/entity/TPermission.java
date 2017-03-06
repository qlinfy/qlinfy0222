package com.zhuyuan.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Administrator on 2017/3/2.
 */
@Entity
@Table(name = "t_permission", schema = "qlinfy20160802", catalog = "")
public class TPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int permissionId;
    private String permissionName;
    private Date createdTime;
    private Date updateTime;

    @Id
    @Column(name = "permission_id")
    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    @Basic
    @Column(name = "permission_name")
    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Basic
    @Column(name = "created_time")
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Basic
    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


}
