package com.sj.damai.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sj.damai.biz.BizException;
import com.sj.damai.biz.UserBiz;
import com.sj.damai.po.Result;
import com.sj.damai.po.User;

@RestController
public class UserAction {

	@Resource
	private UserBiz ubiz;
	@RequestMapping(path="user.s",params="op=login")
	public Result login(String username,String password,HttpSession session,String vcode)  {
		try {
			session.setAttribute("loginUser",ubiz.queryOne(username, password,session,vcode) );
		} catch (BizException e) {
			return Result.failure(e.getMessage());
		} catch (IOException e) {
			return Result.failure(e.getMessage());
		}
		return Result.success("登陆成功");
		
		
	}
	@RequestMapping(path="user.s",params="op=getLoginedUser")
	public User getLoginUser(HttpSession session) {
		return (User) session.getAttribute("loginUser");
	}
}
