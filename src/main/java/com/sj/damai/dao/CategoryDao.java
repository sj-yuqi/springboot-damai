package com.sj.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sj.damai.po.Category;

@Repository
public class CategoryDao extends BaseDao{
	
	//查询所有
	public List<Category> selectAll(){
		String sql="select * from category";
		return jt.query(sql, categoryRowMapper);
	}
	RowMapper<Category> categoryRowMapper=new RowMapper<Category>() {
		@Override
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			Category cg=new Category();
			cg.setCid(rs.getInt("cid"));
			cg.setCname(rs.getString("cname"));
			return cg;
		}
	
	};
}
