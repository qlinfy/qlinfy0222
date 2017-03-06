package com.zhuyuan.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/3/2.
 */
@Entity
@Table(name = "t_user_role", schema = "qlinfy20160802", catalog = "")
public class TUserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private int roleId;


    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
