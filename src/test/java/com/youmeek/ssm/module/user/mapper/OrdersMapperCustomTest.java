package com.youmeek.ssm.module.user.mapper;

import com.youmeek.ssm.module.user.entities.Orders;
import com.youmeek.ssm.module.user.entities.OrdersCustom;
import com.youmeek.ssm.module.user.entities.SSMTestUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by admin on 2016/5/31.
 */
public class OrdersMapperCustomTest {

    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        // 创建sqlSessionFactory

        // mybatis配置文件
        String resource = "SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建会话工厂，传入mybatis的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindOrdersUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession
                .getMapper(OrdersMapperCustom.class);

        // 调用maper的方法
        List<OrdersCustom> list = ordersMapperCustom.findOrdersUser();

        System.out.println(list);

        sqlSession.close();
    }
    @Test
    public void testFindOrdersUserResultMap() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession
                .getMapper(OrdersMapperCustom.class);

        // 调用maper的方法
        List<Orders> list = ordersMapperCustom.findOrdersUserResultMap();

        System.out.println(list);

        sqlSession.close();
    }
    @Test
    public void testFindOrdersAndOrderDetailResultMap() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession
                .getMapper(OrdersMapperCustom.class);

        // 调用maper的方法
        List<Orders> list = ordersMapperCustom
                .findOrdersAndOrderDetailResultMap();

        System.out.println(list);

        sqlSession.close();
    }
    @Test
    public void testFindUserAndItemsResultMap() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession
                .getMapper(OrdersMapperCustom.class);

        // 调用maper的方法
        List<SSMTestUser> list = ordersMapperCustom.findUserAndItemsResultMap();

        System.out.println(list);

        sqlSession.close();
    }
    @Test
    public void testFindOrdersUserLazyLoading() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();// 创建代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession
                .getMapper(OrdersMapperCustom.class);
        // 查询订单信息（单表）
        List<Orders> list = ordersMapperCustom.findOrdersUserLazyLoading();

        // 遍历上边的订单列表
        for (Orders orders : list) {
            // 执行getUser()去查询用户信息，这里实现按需加载
            SSMTestUser user = orders.getUser();
            System.out.println(user);
        }

    }
}