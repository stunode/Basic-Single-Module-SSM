package com.youmeek.ssm.module.user.mapper;

import java.util.List;

import com.youmeek.ssm.module.user.entities.SSMTestUser;
import com.youmeek.ssm.module.user.entities.SSMTestUserQueryVo;
import com.youmeek.ssm.module.user.entities.SSMTestUserCustom;

/**
 *
 * <p>Title: UserMapper</p>
 * <p>Description: mapper接口，相当 于dao接口，用户管理</p>
 * <p>Company: www.itcast.com</p>
 * @author	传智.燕青
 * @date	2015-4-22下午2:45:12
 * @version 1.0
 */
public interface SSMTestMapper {

    //用户信息综合查询
    public List<SSMTestUserCustom> findUserList(SSMTestUserQueryVo userQueryVo) throws Exception;
//
    //用户信息综合查询总数
    public int findUserCount(SSMTestUserQueryVo userQueryVo) throws Exception;

    //根据id查询用户信息
    public SSMTestUser findUserById(int id) throws Exception;

    //根据id查询用户信息，使用resultMap输出
    public SSMTestUser findUserByIdResultMap(int id) throws Exception;


    //根据用户名列查询用户列表
    public List<SSMTestUser> findUserByName(String name)throws Exception;

    //插入用户
    public void insertUser(SSMTestUser user)throws Exception;

    //删除用户
    public void deleteUser(int id)throws Exception;




}
