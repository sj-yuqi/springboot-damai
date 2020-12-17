package com.sj.damai.biz;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.sj.damai.dao.UserDao;
import com.sj.damai.po.User;
import com.sj.damai.util.Utils;

@Service
public class UserBiz {
	
	@Resource
	private UserDao udao;
	@Resource 
	private User u;
	public User queryOne(String username,String password,HttpSession session,String vcode) throws BizException, IOException {
		Utils.checkNull(username, "用户名不能为空！");
		Utils.checkNull(password, "密码不能为空！");
		String vcodes=(String) session.getAttribute("vcode");
		if(!vcodes.equalsIgnoreCase(vcode)) {
			throw new BizException("验证码错误!");
		}
		if(udao.selectOne(username, password)!=null) {
			u=udao.selectOne(username, password);
		}else {
			throw new BizException("用户名密码错误！");
		}
		return u;
		
	}
	
	public void register(User user) throws BizException {
		Utils.checkNull(user.getName(), "用户名不能为空");
		Utils.checkNull(user.getPassword(), "密码不能为空");
		Utils.checkNull(user.getEmail(), "邮箱不能为空");
		Utils.checkNull(user.getPhone(), "电话不能为空");
	}
}
