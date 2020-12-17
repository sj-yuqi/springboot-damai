package com.sj.damai.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RestController;

import com.sj.damai.biz.BizException;
import com.sj.damai.biz.OrdersBiz;
import com.sj.damai.po.Orders;
import com.sj.damai.po.Result;
import com.sj.damai.po.User;

@RestController
public class OrdersAction {
	
	@Resource
	private OrdersBiz obiz;
	
	public Result pay(Orders orders,HttpSession session) {
		User user=(User) session.getAttribute("loginUser");
		orders.setUid(user.getUid());
		try {
			obiz.pay(orders);
			return Result.success("订单提交成功!");
		} catch (BizException e) {
			e.printStackTrace();
			return Result.failure("提交失败");
		}
	}
}
