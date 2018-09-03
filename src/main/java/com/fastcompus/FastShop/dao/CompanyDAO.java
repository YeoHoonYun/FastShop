package com.fastcompus.FastShop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.fastcompus.FastShop.vo.CompanyVO;

public class CompanyDAO extends SqlSessionDaoSupport{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(CompanyVO companyVO) {
		System.out.println("22222222222222");
		getSqlSession().insert("Company.insert", companyVO);
	}
	
	public List<CompanyVO> selectList() {
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList("Company.selectList", paramMap);
	}
	
	public CompanyVO select(String id) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("id", id);
		return getSqlSession().selectOne("Company.select", id);
	}
	
	public void update(CompanyVO companyVO) {
		getSqlSession().update("Company.update", companyVO);
	}
	
	public void delete(int id) {
		getSqlSession().delete("Company.delete", id);
	}
}