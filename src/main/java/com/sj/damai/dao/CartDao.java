package com.sj.damai.dao;


import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public class CartDao extends BaseDao{
	
	//查询所有的订单
	public List<?> selectAll(int uid){
		String sql="select p.image,p.pname,p.shop_price,c.count from "
				+ " product p,cart c where p.pid=c.pid and c.uid=?";
		return jt.queryForList(sql, uid);
	}
	
	
	//新增购物车
	public int insertCart(int uid,int pid,int count) {
		String sql="insert into cart values(default,?,?,?)";
		return jt.update(sql, uid,pid,count);
	}
	//添加购物车
	public int addCart(int uid,int pid,int count) {
		String sql="update cart set count=count + ? where uid=? and pid=?";
		return jt.update(sql,count,uid,pid);
	}
	//计算总和
	public Double selectTotalByUid(Integer uid) {
		String sql="select sum(count*shop_price) from cart a join product p where a.pid=p.pid and uid=?";
		return jt.queryForObject(sql, Double.class,uid);
	}

	public void deleteByUid(Integer uid) {
		jt.update("delete from cart where uid=?",uid);
	}
}
