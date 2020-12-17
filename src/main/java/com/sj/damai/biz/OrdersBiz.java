package com.sj.damai.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sj.damai.dao.CartDao;
import com.sj.damai.dao.OrdersDao;
import com.sj.damai.po.Orders;
import com.sj.damai.util.Utils;

@Service
public class OrdersBiz {
	@Resource
	private CartDao cdao;
	@Resource 
	private OrdersDao odao;
	
	//提交购物车功能
	@Transactional
	public void pay(Orders orders) throws BizException {
		Utils.checkNull(orders.getName(), "收货人姓名不能为空!");
		Utils.checkNull(orders.getAddr(), "地址不能为空!");
		Utils.checkNull(orders.getPhone(), "电话号码不能为空");
		
		Double total=cdao.selectTotalByUid(orders.getUid());
		orders.setTotal(total);
		orders.setState(0);
		
		odao.insertOrders(orders);
		odao.insertOrdersItem(orders);
		cdao.deleteByUid(orders.getUid());
		
	}

}
