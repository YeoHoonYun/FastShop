package test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fastcompus.FastBlog.dao.UserDAO;
import com.fastcompus.FastBlog.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class UserDAOTest {
	@Autowired
	protected UserDAO userDAO;
	
	@Test
	public void insert() {
		System.out.println("-------------");
		UserVO userVO = new UserVO();
		userVO.setFirstName("2");
		userVO.setName("2");
		userVO.setEmail("2");
		userVO.setPasswd("2");
		userVO.setAddress("2");
		System.out.println(userVO.getAddress());
		System.out.println(userVO.getName());
		System.out.println(userVO.getFirstName());
		System.out.println(userVO.getEmail());
		System.out.println(userVO.getPasswd());
		
		userDAO.insert(userVO);
	}

}
