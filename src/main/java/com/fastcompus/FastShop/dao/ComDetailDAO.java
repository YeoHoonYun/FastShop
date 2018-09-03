package com.fastcompus.FastShop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.fastcompus.FastShop.vo.ComDetailVO;

public class ComDetailDAO extends SqlSessionDaoSupport{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(ComDetailVO comDetailVO) {
		System.out.println("22222222222222");
		getSqlSession().insert("ComDetail.insert", comDetailVO);
	}
	
	public List<ComDetailVO> selectList() {
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList("ComDetail.selectList", paramMap);
	}
	
	public ComDetailVO select(String id) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("id", id);
		return getSqlSession().selectOne("ComDetail.select", id);
	}
	
	public void update(ComDetailVO comDetailVO) {
		getSqlSession().update("ComDetail.update", comDetailVO);
	}
	
	public void delete(int id) {
		getSqlSession().delete("ComDetail.delete", id);
	}
}