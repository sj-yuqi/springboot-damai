package com.sj.damai.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sj.damai.biz.BizException;
import com.sj.damai.biz.CartBiz;
import com.sj.damai.dao.CartDao;
import com.sj.damai.po.Result;
import com.sj.damai.po.User;

@RestController
public class CartAction {
	@Resource
	private CartDao cdao;
	@Resource
	HttpSession session;
	@Resource
	User u;
	@Resource
	private CartBiz cbiz;
	//购物车查询所有
	@RequestMapping(path="cart.s",params="op=queryAll")
	public List<?> queryAll(){
		u=(User)session.getAttribute("loginUser");
		return cdao.selectAll(u.getUid());
	}
	//添加购物车操作
	@RequestMapping(path="cart.s",params="op=addCart")
	public Result addCart(int pid,int count) {
		u=(User) session.getAttribute("loginUser");
		try {
			cbiz.addCart(u.getUid(), pid, count);
			return Result.success("添加购物车成功");
		} catch (BizException e) {
			return Result.failure(e.getMessage());
		}
	}

}
