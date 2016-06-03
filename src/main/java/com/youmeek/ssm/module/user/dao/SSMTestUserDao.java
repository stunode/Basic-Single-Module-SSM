package com.youmeek.ssm.module.user.dao;

import com.youmeek.ssm.module.user.entities.SSMTestUser;

import java.util.List;

/**
 * Created by Administrator on 2016/5/30.
 */
public interface SSMTestUserDao {
    //根据id查询用户信息
    public SSMTestUser findUserById(int id) throws Exception;

//    //根据用户名列查询用户列表
//    public List<SSMTestUser> findUserByName(String name) throws Exception;
//
//    //添加用户信息
//    public void insertUser(SSMTestUser user) throws Exception;
//
//    //删除用户信息
//    public void deleteUser(int id) throws Exception;
}
