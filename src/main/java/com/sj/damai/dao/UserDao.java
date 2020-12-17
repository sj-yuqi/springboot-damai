package com.sj.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sj.damai.po.Product;
import com.sj.damai.po.User;

@Repository
public class UserDao extends BaseDao{
	
	
	//login
	public User selectOne(String username, String password) {
		String sql="select * from user where username=? and password=?";
		return jt.query(sql, rs->{
			return rs.next() ? userRowMapper.mapRow(rs, -1) :null;
		}, username ,password);
	}
	//register
	public void insertOne(User user) {
		String sql="insert into user values(default,?,?,?,?,?,?,null,null,?)";
		jt.update(sql, user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getPhone(),user.getSex(),user.getAddr());
	}
	RowMapper<User> userRowMapper=new RowMapper<User>() {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user=new User();
			user.setAddr(rs.getString("addr"));
			user.setCode(rs.getString("code"));
			user.setEmail(rs.getString("email"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			user.setSex(rs.getString("sex"));
			user.setState(rs.getInt("State"));
			user.setUid(rs.getInt("uid"));
			user.setUsername(rs.getString("username"));
			return user;
		}
	};
}
