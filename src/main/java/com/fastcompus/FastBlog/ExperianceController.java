package com.fastcompus.FastBlog;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fastcompus.FastBlog.vo.UserVO;

@Controller
public class ExperianceController {
	@RequestMapping(value = "/experiance", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		UserVO userVO = new UserVO();
		userVO.setEmail("test@test.com");
		
		return "experiance";
	}

}
