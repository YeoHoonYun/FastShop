package com.fastcompus.FastBlog.bo;

import com.fastcompus.FastBlog.dao.UserDAO;
import com.fastcompus.FastBlog.vo.UserVO;

public class UserBO {
	//1:1 ���迡 �ִ� �͵鿡 ���ؼ� �ѹ��� ����°� ������ֱ� ���ؼ� ���� �Լ��� ����
	
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
