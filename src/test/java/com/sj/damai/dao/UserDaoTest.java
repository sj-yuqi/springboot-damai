package com.sj.damai.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDaoTest {
	@Resource 
	private CartDao cdao;
	@Test
	public void test01() {
		List<?> list=cdao.selectAll(9);
	}
	
}
