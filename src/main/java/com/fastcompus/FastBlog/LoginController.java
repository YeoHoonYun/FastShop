package com.fastcompus.FastBlog;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fastcompus.FastBlog.dao.UserDAO;
import com.fastcompus.FastBlog.dao.UserDetailDAO;
import com.fastcompus.FastBlog.vo.UserVO;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserDAO userDAO;
	private UserDetailDAO userDetailDAO;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model
			, @SessionAttribute(required=false, value="sessionUsername") String sessionUsername) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		if(sessionUsername == null || sessionUsername.equals("")) {
			return "login";
			
		}else {
			// 로그인이 되어 있는 상태
			return "redirect:login";
		}
	}
	
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(
			@SessionAttribute(required=false, value="sessionUsername") String sessionUsername
			, @RequestParam(value="username") String username
			, @RequestParam(value="passwd") String passwd
			, Model model) {
		
		//userDAO.select(id)
		UserVO userVO = userDAO.selectByUsername(username);
		if(userVO == null) {
			return "redirect:/login";
		}
		
		if ( userVO.getPasswd().equals(passwd) ) {
			// 로그인 성공
			model.addAttribute("sessionUsername", userVO.getName());
			model.addAttribute("sessionEmail", userVO.getEmail());
			
			return "redirect:/login";
		} else
		{
			// 로그인 실패: 비밀번호가 다르니까.
			model.addAttribute("sessionUsername", "");
			model.addAttribute("sessionEmail", "");
		}
		
		return "redirect:/login";
	}
}
