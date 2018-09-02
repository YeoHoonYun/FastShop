package com.fastcompus.FastBlog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.fastcompus.FastBlog.vo.OrderVO;

public class OrderDAO extends SqlSessionDaoSupport{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(OrderVO orderVO) {
		System.out.println("22222222222222");
		getSqlSession().insert("Order.insert", orderVO);
	}
	
	public List<OrderVO> selectList() {
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList("Order.selectList", paramMap);
	}
	
	public OrderVO select(String id) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("id", id);
		return getSqlSession().selectOne("Order.select", id);
	}
	
	public void update(OrderVO orderVO) {
		getSqlSession().update("Order.update", orderVO);
	}
	
	public void delete(int id) {
		getSqlSession().delete("Order.delete", id);
	}
}