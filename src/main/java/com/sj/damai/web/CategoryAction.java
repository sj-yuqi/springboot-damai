package com.sj.damai.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sj.damai.dao.CategoryDao;
import com.sj.damai.dao.CategorysecondDao;

@RestController
public class CategoryAction {
	@Resource
	private CategoryDao cdao;
	@Resource
	private CategorysecondDao csdao;
	@RequestMapping(path="category.s",params="op=selectAll")
	public List<?> selectAll(){
		return cdao.selectAll();
	}
	
	@RequestMapping(path="category.s",params="op=queryAll")
	public Map<String, Object> queryAll(){
		Map<String,Object> data=new HashMap<>();
		data.put("clist", cdao.selectAll());
		data.put("cslist",csdao.selectAllSec());
		return data;
	}
}
