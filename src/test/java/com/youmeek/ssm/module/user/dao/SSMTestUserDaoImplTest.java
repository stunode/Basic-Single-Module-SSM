package com.youmeek.ssm.module.user.dao;

import com.youmeek.ssm.module.user.entities.SSMTestUser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by admin on 2016/6/2.
 */
public class SSMTestUserDaoImplTest {

    private ApplicationContext applicationContext;

    //在setUp这个方法得到spring容器
    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    }

    @Test
    public void testFindUserById() throws Exception {

        SSMTestUserDao userDao = (SSMTestUserDao) applicationContext.getBean("userDao");

        //调用userDao的方法
        SSMTestUser user = userDao.findUserById(1);

        System.out.println(user);

    }
}