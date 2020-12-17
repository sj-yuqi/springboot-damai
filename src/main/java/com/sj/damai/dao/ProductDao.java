package com.sj.damai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sj.damai.po.Product;

@Repository
public class ProductDao extends BaseDao{
	
	//热门商品查询
	public  List<Product> selectHot(){
		String sql="select * from product where is_hot=1 limit 0,10";
		return jt.query(sql, productRowMapper);
	}
	//最新商品查询
	public List<Product>selectNew(){
		String sql="select * from product order by pdate desc limit 0,10";
		return jt.query(sql, productRowMapper);
	}
	/**
	 * 
	 */
	//详情页面
	public Product selectById(int id) {
		String sql="select * from product where pid = ?";
//		return jt.query(sql,new ResultSetExtractor<Product>() {
//
//			@Override
//			public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
//				rs.next();
//				return ProductRowMapper.mapRow(rs, -1);
//			}
//			
//		}, id);
		return jt.query(sql, rs->{ //lamda表达式
			//ResultSetExtractor接口中方法，要求手动执行结果集的next()方法
			return rs.next() ? productRowMapper.mapRow(rs, -1) :null;
		},id);
	}
	RowMapper<Product> productRowMapper=new RowMapper<Product>() {

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product p=new Product();
			p.setPid(rs.getInt("pid"));
			p.setCsid(rs.getInt("csid"));
			p.setImage(rs.getString("image"));
			p.setIsHot(rs.getInt("is_hot"));
			p.setMarketPrice(rs.getDouble("market_price"));
			p.setPdate(rs.getDate("pdate"));
			p.setPdesc(rs.getString("pdesc"));
			p.setPname(rs.getString("pname"));
			p.setShopPrice(rs.getDouble("shop_price"));
			return p;
		
		}
		
	};
}	
