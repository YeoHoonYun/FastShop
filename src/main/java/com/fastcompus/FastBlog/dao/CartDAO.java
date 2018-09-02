package com.fastcompus.FastBlog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.fastcompus.FastBlog.vo.CartVO;

public class CartDAO extends SqlSessionDaoSupport{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(CartVO cartVO) {
		System.out.println("22222222222222");
		getSqlSession().insert("Cart.insert", cartVO);
	}
	
	public List<CartVO> selectList() {
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList("Cart.selectList", paramMap);
	}
	
	public CartVO select(String id) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("id", id);
		return getSqlSession().selectOne("Cart.select", id);
	}
	
	public void update(CartVO cartVO) {
		getSqlSession().update("Cart.update", cartVO);
	}
	
	public void delete(int id) {
		getSqlSession().delete("Cart.delete", id);
	}
}