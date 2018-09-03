package com.fastcompus.FastShop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.fastcompus.FastShop.vo.UserVO;

public class UserDAO extends SqlSessionDaoSupport{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(UserVO userVO) {
		System.out.println("22222222222222");
		getSqlSession().insert("User.insert", userVO);
	}
	
	public List<UserVO> selectList() {
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList("User.selectList", paramMap);
	}
	
	public UserVO select(String id) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("id", id);
		return getSqlSession().selectOne("User.select", id);
	}
	
	public void update(UserVO userVO) {
		getSqlSession().update("User.update", userVO);
	}
	
	public void delete(int id) {
		getSqlSession().delete("User.delete", id);
	}
}
