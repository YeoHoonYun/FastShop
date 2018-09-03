package com.fastcompus.FastBlog;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fastcompus.FastBlog.dao.UserDAO;
import com.fastcompus.FastBlog.dao.UserDetailDAO;
import com.fastcompus.FastBlog.vo.UserDetailVO;
import com.fastcompus.FastBlog.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserDetailDAO userDetailDAO;
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/admin/users/list", method = RequestMethod.GET)
	public String list(Locale locale, Model model) {
		List<UserVO> userList = userDAO.selectList();
		model.addAttribute("userList", userList);	
		return "admin/users/list";
	}
	
	@RequestMapping(value = "/admin/users/userDetail", method = RequestMethod.GET)
	public String userDetail(@RequestParam("id") int id, Locale locale, Model model) {
		UserDetailVO userDetailOne = userDetailDAO.select(id);
		model.addAttribute("userDetailOne", userDetailOne);
		return "admin/users/userDetail";
	}
	
}
