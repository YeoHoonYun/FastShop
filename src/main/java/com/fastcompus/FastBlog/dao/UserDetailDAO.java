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
		System.out.println(userDetailVO.getHobby());
		getSqlSession().insert("UserDetail.insert", userDetailVO);
	}
	
	public List<UserDetailVO> selectList() {
		Map<String, String> paramMap = new HashMap<String, String>();
		return getSqlSession().selectList("UserDetail.selectList", paramMap);
	}
	
	public UserDetailVO select(int id) {
		UserDetailVO paramMap = new UserDetailVO();
		paramMap.setUsersId(id);
		return getSqlSession().selectOne("UserDetail.select", paramMap);
	}
	
	public void update(UserDetailVO userDetailVO) {
		getSqlSession().update("UserDetail.update", userDetailVO);
	}
	
	public void delete(int id) {
		getSqlSession().delete("UserDetail.delete", id);
	}
}