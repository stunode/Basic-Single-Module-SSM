package com.youmeek.ssm.module.user.mapper;

import com.youmeek.ssm.module.user.entities.SSMTestUser;
import com.youmeek.ssm.module.user.entities.SSMTestUserCustom;
import com.youmeek.ssm.module.user.entities.SSMTestUserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/5/30.
 */
public class SSMTestMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
//        super.setUp();
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
    public void testFindUserList() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建UserMapper对象，mybatis自动生成mapper代理对象
        SSMTestMapper userMapper = sqlSession.getMapper(SSMTestMapper.class);

        //创建包装对象，设置查询条件
        SSMTestUserQueryVo userQueryVo = new SSMTestUserQueryVo();
        SSMTestUserCustom userCustom = new SSMTestUserCustom();
        //由于这里使用动态sql，如果不设置某个值，条件不会拼接在sql中
//		userCustom.setSex("1");
        userCustom.setUsername("小明");
        //传入多个id
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(10);
        ids.add(16);
        //将ids通过userQueryVo传入statement中
        userQueryVo.setIds(ids);
        userQueryVo.setUserCustom(userCustom);
        //调用userMapper的方法

        List<SSMTestUserCustom> list = userMapper.findUserList(userQueryVo);

        System.out.println(list);


    }


    @Test
    public void testFindUserById() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建UserMapper对象，mybatis自动生成mapper代理对象
        SSMTestMapper userMapper = sqlSession.getMapper(SSMTestMapper.class);

        //调用userMapper的方法

        SSMTestUser user = userMapper.findUserById(10);

        System.out.println(user);


    }
    @Test
    public void testFindUserCount() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建UserMapper对象，mybatis自动生成mapper代理对象
        SSMTestMapper userMapper = sqlSession.getMapper( SSMTestMapper.class);

        //创建包装对象，设置查询条件
        SSMTestUserQueryVo userQueryVo = new  SSMTestUserQueryVo();
        SSMTestUserCustom userCustom = new  SSMTestUserCustom();
        userCustom.setSex("1");
        userCustom.setUsername("张三丰");
        userQueryVo.setUserCustom(userCustom);
        //调用userMapper的方法

        int count = userMapper.findUserCount(userQueryVo);

        System.out.println(count);


    }
    @Test
    public void testFindUserByIdResultMap() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建UserMapper对象，mybatis自动生成mapper代理对象
        SSMTestMapper userMapper = sqlSession.getMapper(SSMTestMapper.class);

        //调用userMapper的方法

        SSMTestUser user = userMapper.findUserByIdResultMap(10);

        System.out.println(user);


    }
}