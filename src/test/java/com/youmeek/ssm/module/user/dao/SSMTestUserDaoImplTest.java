package com.youmeek.ssm.module.user.dao;

import com.youmeek.ssm.module.user.daoimpl.SSMTestUserDaoImpl;
import com.youmeek.ssm.module.user.entities.SSMTestUser;
import com.youmeek.ssm.module.user.ssmdao.SSMTestUserDao1;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2016/5/30.
 */
public class SSMTestUserDaoImplTest extends TestCase {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        super.setUp();
        // 创建sqlSessionFactory

        // mybatis配置文件
        String resource = "SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建会话工厂，传入mybatis的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);
    }
    @Test
    public void testFindUserByid() throws Exception {
// 创建UserDao的对象
        SSMTestUserDao1 userDao = new SSMTestUserDaoImpl(sqlSessionFactory);

        // 调用UserDao的方法
        SSMTestUser user = userDao.findUserByid(10);

        System.out.println(user);
    }
    @Test
    public void testFindUserByName() throws Exception {
// 创建UserDao的对象
        SSMTestUserDao1 userDao =  new SSMTestUserDaoImpl(sqlSessionFactory);

        // 调用UserDao的方法
        List<SSMTestUser> user = userDao.findUserByName("明");

        System.out.println(user);
    }
}