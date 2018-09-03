import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fastcompus.FastBlog.dao.UserDetailDAO;
import com.fastcompus.FastBlog.vo.UserDetailVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class UserDetailDAOTest {
	@Autowired //������ ��ü�� ������ �ڵ����� ����
	protected UserDetailDAO userDetailDAO;
	
	@Test
	public void insert() {
		UserDetailVO userDetailVO = new UserDetailVO();
		userDetailVO.setUsersId(4);
		userDetailVO.setHobby("�ֽ�");
		userDetailVO.setSpecialty("�׽�Ʈ �Դϴ�.");
		
		userDetailDAO.insert(userDetailVO);
	}
	
//	@Test
//	public void select() {
//		UserDetailVO userDetailOne = userDetailDAO.select(1);
//		System.out.println(userDetailOne.getHobby());
//	}
}
