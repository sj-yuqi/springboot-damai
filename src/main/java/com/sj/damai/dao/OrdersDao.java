package com.sj.damai.dao;

import org.springframework.stereotype.Repository;

import com.sj.damai.po.Orders;

@Repository
public class OrdersDao extends BaseDao{

	public void insertOrders(Orders orders) {
		String sql="insert into orders values(null,?,now(),?,?,?,?,?)";
		jt.update(sql, orders.getTotal(), orders.getState(), orders.getAddr(), orders.getPhone(), orders.getUid(),
				orders.getName());

	}

	public void insertOrdersItem(Orders orders) {
		String sql="insert into orderitem select null,a.count,a.count*p.shop_price,a.pid,LAST_INSERT_ID()  "
				+ " from cart a join product p where a.pid=p.pid and a.uid=?";
		jt.update(sql,orders.getUid());
	}
	
	

}
