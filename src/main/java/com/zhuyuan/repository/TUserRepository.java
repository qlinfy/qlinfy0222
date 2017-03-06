package com.zhuyuan.repository;

import com.zhuyuan.entity.TUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/3/2.
 */
@Transactional
public interface TUserRepository extends JpaRepository<TUser,Integer> {

    TUser findByUserName(String userName);


}