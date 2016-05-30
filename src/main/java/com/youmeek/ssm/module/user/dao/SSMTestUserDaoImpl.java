package com.youmeek.ssm.module.user.dao;

import java.util.Date;
import java.util.List;
import com.youmeek.ssm.module.user.dao.SSMTestUserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.youmeek.ssm.module.user.entities.SSMTestUser;

/**
 * 
 * <p>
 * Title: UserDaoImpl
 * </p>
 * <p>
 * Description:dao接口实现类
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 传智.燕青
 * @date 2015-4-22下午2:47:17
 * @version 1.0
 */
public class SSMTestUserDaoImpl implements SSMTestUserDao {

	// 需要向dao实现类中注入SqlSessionFactory
	// 这里通过构造方法注入
	private SqlSessionFactory sqlSessionFactory;

	public SSMTestUserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public SSMTestUser findUserById(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		SSMTestUser user = sqlSession.selectOne("test.findUserById", id);

		// 释放资源
		sqlSession.close();

		return user;

	}
	
	@Override
	public List<SSMTestUser> findUserByName(String name) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		List<SSMTestUser> list = sqlSession.selectList("test.findUserByName", name);

		// 释放资源
		sqlSession.close();

		return list;
	}
	

	@Override
	public void insertUser(SSMTestUser user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//执行插入操作
		sqlSession.insert("test.insertUser", user);

		// 提交事务
		sqlSession.commit();

		// 释放资源
		sqlSession.close();

	}

	@Override
	public void deleteUser(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//执行插入操作
		sqlSession.delete("test.deleteUser", id);

		// 提交事务
		sqlSession.commit();

		// 释放资源
		sqlSession.close();

	}



}
