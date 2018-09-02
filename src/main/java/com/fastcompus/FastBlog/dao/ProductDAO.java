package com.fastcompus.FastBlog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.fastcompus.FastBlog.vo.ProductVO;

public class ProductDAO extends SqlSessionDaoSupport{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(ProductVO productVo) {
		System.out.println("22222222222222");
		getSqlSession().insert("Product.insert", productVo);
	}
	
	public List<ProductVO> selectList() {
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList("Product.selectList", paramMap);
	}
	
	public ProductVO select(String id) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("id", id);
		return getSqlSession().selectOne("Product.select", id);
	}
	
	public void update(ProductVO productVo) {
		getSqlSession().update("Product.update", productVo);
	}
	
	public void delete(int id) {
		getSqlSession().delete("Product.delete", id);
	}
}