package com.sj.damai.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sj.damai.dao.ProductDao;
import com.sj.damai.po.Product;

@RestController
public class ProductAction {
	@Resource
	private ProductDao pdao;
	
	@RequestMapping(path="product.s",params="op=queryHot")
	public List<?> queryHot(){
		return pdao.selectHot();
	}
	@RequestMapping(path="product.s",params="op=queryNew")
	public List<?>queryNew(){
		return pdao.selectNew();
	}
	@RequestMapping(path="product.s",params="op=queryById")
	public Product queryById(int pid) {
		return pdao.selectById(pid);
	}
}
