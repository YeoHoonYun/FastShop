
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fastcompus.FastBlog.dao.UserDAO;
import com.fastcompus.FastBlog.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class UserDAOTest {
	@Autowired //동일한 객체인 변수를 자동으로 선언
	protected UserDAO userDAO;
	
	@Test
	public void insert() {
		UserVO userVO = new UserVO();
		userVO.setName("윤은하");
		userVO.setEmail("yyh9595@naver.com");
		userVO.setPasswd("1234");
		userVO.setAddress("경기 안산시");
		
		userDAO.insert(userVO);
	}
	
//	@Test
//	public void selectList() {
//		List<UserVO> userList = userDAO.selectList();
//		System.out.println(userList);
//		for (UserVO userVO : userList) {
//			System.out.println(userVO.getName());
//			assertTrue(userVO instanceof UserVO);
//		}
//	}
	
//	@Test
//	public void update() {
//		UserVO userVO = new UserVO();
//		userVO.setId(1);
//		userVO.setName("30");
//		userVO.setEmail("30");
//		userVO.setPasswd("30");
//		userVO.setAddress("30");
//		
//		userDAO.update(userVO);
//	}
//	
//	@Test
//	public void delete() {
//		UserVO userVO = new UserVO();
//		userVO.setId(3);
//		userDAO.delete(userVO.getId());
//	}

}
