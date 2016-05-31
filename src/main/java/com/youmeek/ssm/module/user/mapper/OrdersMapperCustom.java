package com.youmeek.ssm.module.user.mapper;

import java.util.List;

import com.youmeek.ssm.module.user.entities.Orders;
import com.youmeek.ssm.module.user.entities.OrdersCustom;
import com.youmeek.ssm.module.user.entities.SSMTestUser;

/**
 * 
 * <p>Title: OrdersMapperCustom</p>
 * <p>Description: 订单mapper</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-4-23上午10:28:43
 * @version 1.0
 */
public interface OrdersMapperCustom {
	
	//查询订单关联查询用户信息
	public List<OrdersCustom> findOrdersUser()throws Exception;
	
	//查询订单关联查询用户使用resultMap
	public List<Orders> findOrdersUserResultMap()throws Exception;
	//查询订单(关联用户)及订单明细
	public List<Orders>  findOrdersAndOrderDetailResultMap()throws Exception;
	
	//查询用户购买商品信息
	public List<SSMTestUser>  findUserAndItemsResultMap()throws Exception;
	
	//查询订单关联查询用户，用户信息是延迟加载
	public List<Orders> findOrdersUserLazyLoading()throws Exception;

}
