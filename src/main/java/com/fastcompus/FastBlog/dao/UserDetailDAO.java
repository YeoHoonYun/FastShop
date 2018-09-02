package com.fastcompus.FastBlog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.fastcompus.FastBlog.vo.UserDetailVO;

public class UserDetailDAO extends SqlSessionDaoSupport{
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(UserDetailVO userDetailVO) {
		System.out.println("22222222222222");
		getSqlSession().insert("User.insert", userDetailVO);
	}
	
	public List<UserDetailVO> selectList() {
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList("User.selectList", paramMap);
	}
	
	public UserDetailVO select(String id) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("id", id);
		return getSqlSession().selectOne("User.select", id);
	}
	
	public void update(UserDetailVO userDetailVO) {
		getSqlSession().update("User.update", userDetailVO);
	}
	
	public void delete(int id) {
		getSqlSession().delete("User.delete", id);
	}
}