package com.youmeek.ssm.module.user.mapper;

import com.youmeek.ssm.module.user.entities.SysUser1;

public interface SysUser1Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user1
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user1
     *
     * @mbggenerated
     */
    int insert(SysUser1 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user1
     *
     * @mbggenerated
     */
    int insertSelective(SysUser1 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user1
     *
     * @mbggenerated
     */
    SysUser1 selectByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user1
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysUser1 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user1
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysUser1 record);
}