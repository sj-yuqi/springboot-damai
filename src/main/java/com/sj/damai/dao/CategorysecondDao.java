package com.sj.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sj.damai.po.Categorysecond;

@Repository
public class CategorysecondDao extends BaseDao{

	public List<Categorysecond> selectAllSec(){
		String sql="select * from categorysecond ";
		return jt.query(sql, ProductRowMapper);
	}
	RowMapper<Categorysecond> ProductRowMapper=new RowMapper<Categorysecond>() {
		@Override
		public Categorysecond mapRow(ResultSet rs, int rowNum) throws SQLException {
			Categorysecond cgs=new Categorysecond();
			cgs.setCid(rs.getInt("cid"));
			cgs.setCsid(rs.getInt("csid"));
			cgs.setCsname(rs.getString("csname"));
			return cgs;
		}
	
	};
}
