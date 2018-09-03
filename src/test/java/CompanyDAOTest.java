
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fastcompus.FastBlog.dao.CompanyDAO;
import com.fastcompus.FastBlog.vo.CompanyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class CompanyDAOTest {
	@Autowired //동일한 객체인 변수를 자동으로 선언
	protected CompanyDAO companyDAO;
	
	@Test
	public void insert() {
		CompanyVO companyVO = new CompanyVO();
		companyVO.setName("1");
		companyVO.setEmail("1");
		
		companyDAO.insert(companyVO);
	}
	
	@Test
	public void selectList() {
		List<CompanyVO> CompanyList = companyDAO.selectList();
		System.out.println(CompanyList);
		for (CompanyVO CompanyVO : CompanyList) {
			System.out.println(CompanyVO.getName());
			assertTrue(CompanyVO instanceof CompanyVO);
		}
	}
	
	@Test
	public void update() {
		CompanyVO companyVO = new CompanyVO();
		companyVO.setId(1);
		companyVO.setName("30");
		companyVO.setEmail("30");
		
		companyDAO.update(companyVO);
	}
	
	@Test
	public void delete() {
		CompanyVO companyVO = new CompanyVO();
		companyVO.setId(1);
		companyDAO.delete(companyVO.getId());
	}

}
