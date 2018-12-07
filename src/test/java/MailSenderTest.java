import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fastcompus.FastBlog.MailSender;
import com.fastcompus.FastBlog.dao.CompanyDAO;
import com.fastcompus.FastBlog.vo.CompanyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class MailSenderTest {
	@Test
	public void sendTest() {
		MailSender.sendMail("cjswo9207@gmail.com");
	}
	
}
