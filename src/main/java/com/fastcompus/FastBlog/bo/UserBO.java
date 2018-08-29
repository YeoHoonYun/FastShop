package com.fastcompus.FastBlog.bo;

import com.fastcompus.FastBlog.dao.UserDAO;
import com.fastcompus.FastBlog.vo.UserVO;

public class UserBO {
	//1:1 관계에 있는 것들에 대해서 한번에 지우는걸 만들어주기 위해서 따로 함수만 선언
	
	@Autowired
	protected UserDAO userDAO;
	
	@Autowired
	protected UserDetailDAO userDetailDAO;
	
	public void insert(UserVO userVO, UserDetailDAO userDetailDAO) {
		userDAO.insert(userVO);
		userDetailDAO.insert(userDetailDAO);
	}
	
	public void delete(int id) {
		userDetilDAO.delete(id);
		userDAO.delete(id);
		
	}

}
