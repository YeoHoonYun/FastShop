package com.fastcompus.FastBlog;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcompus.FastBlog.dao.UserDAO;
import com.fastcompus.FastBlog.vo.UserDetailVO;
import com.fastcompus.FastBlog.vo.UserVO;

@Controller
public class RegisterController {
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		UserVO userVO = new UserVO();
		userVO.setEmail("test@test.com");
		
		return "register";
	}
	@RequestMapping(value = "/register/join", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> userJoin(UserVO userVO) {
		
		System.out.println(userVO.getName());
		System.out.println(userVO.getEmail());
		System.out.println(userVO.getPasswd());
		userDAO.insert(userVO);
		
		return null;
	}
}
