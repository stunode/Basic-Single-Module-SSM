package com.youmeek.ssm.module.user.dao;

import com.youmeek.ssm.module.user.entities.SSMTestUser;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class SSMTestUserDaoImpl extends SqlSessionDaoSupport implements SSMTestUserDao {

	@Override
	public SSMTestUser findUserById(int id) {
		SqlSession sqlSession = this.getSqlSession();

		SSMTestUser user = sqlSession.selectOne("test.findUserById", id);

		return user;

	}

//	@Override
//	public List<SSMTestUser> findUserByName(String name) throws Exception {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//
//		List<SSMTestUser> list = sqlSession.selectList("test.findUserByName", name);
//
//		// 释放资源
//		sqlSession.close();
//
//		return list;
//	}
//
//
//	@Override
//	public void insertUser(SSMTestUser user) throws Exception {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//
//		//执行插入操作
//		sqlSession.insert("test.insertUser", user);
//
//		// 提交事务
//		sqlSession.commit();
//
//		// 释放资源
//		sqlSession.close();
//
//	}
//
//	@Override
//	public void deleteUser(int id) throws Exception {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//
//		//执行插入操作
//		sqlSession.delete("test.deleteUser", id);
//
//		// 提交事务
//		sqlSession.commit();
//
//		// 释放资源
//		sqlSession.close();
//
//	}



}
