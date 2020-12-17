package com.sj.damai.biz;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.sj.damai.po.Orders;

@SpringBootTest
public class OrdersTest {

		@Resource
		private OrdersBiz obiz;
		
		@Test
		public void test01() {
			Orders o = new Orders();		
			o.setAddr("衡阳");
			o.setPhone("13800000111");
			o.setName("zhangsan");
			o.setUid(2);
			try {
				obiz.pay(o);
			} catch (BizException e) {
				e.printStackTrace();
			}
		}
}
