
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
		UserVO userVO = new UserVO();
		userVO.setFirstName("1");
		userVO.setName("1");
		userVO.setEmail("1");
		userVO.setPasswd("1");
		userVO.setAddress("1");
		
		userDAO.insert(userVO);
	}

}
