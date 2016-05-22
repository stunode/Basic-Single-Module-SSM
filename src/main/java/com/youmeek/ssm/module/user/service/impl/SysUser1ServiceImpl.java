package com.youmeek.ssm.module.user.service.impl;

import com.youmeek.ssm.module.user.entities.SysUser1;
import com.youmeek.ssm.module.user.mapper.SysUser1Mapper;
import com.youmeek.ssm.module.user.service.SysUser1Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUser1ServiceImpl implements SysUser1Service {
	
	@Resource
	private SysUser1Mapper sysUser1Mapper;


	@Override
	public SysUser1 getById(Long id) {
		return sysUser1Mapper.selectByPrimaryKey(id);
	}
}
