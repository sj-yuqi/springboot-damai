package com.sj.damai.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sj.damai.dao.CartDao;

@Service
public class CartBiz {
	
	@Resource
	private CartDao cdao;
	
	//购物车
	public void addCart(int uid,int pid,int count) throws BizException {
		if(cdao.addCart(uid, pid,count)==0) {
			int i=cdao.insertCart(uid, pid, count);
			if(i==0) {
				throw new BizException("添加购物车失败");
			};
		}
	}
}
