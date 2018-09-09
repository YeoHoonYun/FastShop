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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fastcompus.FastBlog.dao.UserDAO;
import com.fastcompus.FastBlog.dao.UserDetailDAO;
import com.fastcompus.FastBlog.vo.UserDetailVO;
import com.fastcompus.FastBlog.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({"sessionUsername","sessionEmail"})
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private UserDAO userDAO;
	private UserDetailDAO userDetailDAO;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/users/list", method = RequestMethod.GET)
	public String list(
				@ModelAttribute("sessionUsername") String sessionUsername
				, @ModelAttribute("sessionUsername") String sessionEmail
				, @RequestParam(value="username", defaultValue="") String username
				, @RequestParam(value="id", defaultValue="0") int id
				, Model model) {
		
		if ( sessionUsername.equals("") ) {
			return "redirect:/admin/login/login";
		}
		
		List<UserVO> userList = userDAO.selectList();

		model.addAttribute("userList", userList);
		
		System.out.println(sessionUsername);
		
		return "admin/users/list";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/users/info", method = RequestMethod.GET)
	public String info(
			@ModelAttribute("sessionUsername") String sessionUsername
			, @RequestParam(value="id") String id
			, @RequestParam(required=false, value="username") String username
			, Model model) {
		
		UserVO user = userDAO.select(id);
		
		model.addAttribute("userVO", user);

		System.out.println(sessionUsername);
		
		return "admin/users/info";
	}
	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/users/edit", method = RequestMethod.GET)
	public String edit(
			@ModelAttribute("sessionUsername") String sessionUsername
			, @RequestParam(value="id") String id
			, @RequestParam(required=false, value="username") String username
			, Model model) {
		
		UserVO user = userDAO.select(id);
		
		model.addAttribute("userVO", user);

		System.out.println(sessionUsername);
		
		return "admin/users/edit";
	}
	
	
	@RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
	public String add(
			@ModelAttribute("sessionUsername") String sessionUsername
			, Model model) {
		
		return "admin/users/add";
	}
	
	@RequestMapping(value = "/admin/users/doAdd", method = RequestMethod.POST)
	public String doAdd(
			@RequestParam(value="username") String username
			, @RequestParam(value="email") String email
			, @ModelAttribute("sessionUsername") String sessionUsername
			, Model model) {
		
		model.addAttribute("username", username);
		model.addAttribute("email", email);
		
		UserVO userVO = new UserVO();
		userVO.setName(username);
		userVO.setEmail(email);
		
		userDAO.insert(userVO);
		
		return "admin/users/doAdd";
	}
	
	@RequestMapping(value = "/admin/users/doEdit", method = RequestMethod.POST)
	public String doAdd(
			@RequestParam(value="id") int id
			, @RequestParam(value="username") String username
			, @RequestParam(value="email") String email
			, @RequestParam(value="realname") String realname
			, @RequestParam(value="passwd") String passwd
			, @ModelAttribute("sessionUsername") String sessionUsername
			, Model model) {
		
		model.addAttribute("username", username);
		model.addAttribute("email", email);
		
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO.setName(username);
		userVO.setEmail(email);
		userVO.setPasswd(passwd);
		
		userDAO.update(userVO);
		
		return "admin/users/doAdd";
	}
	
	@RequestMapping(value = "/admin/login/login", method = RequestMethod.GET)
	public String login(
			@ModelAttribute("sessionUsername") String sessionUsername
			, Model model) {
	
		
		return "admin/login/login";
	}
	
	@RequestMapping(value = "/admin/login/doLogin", method = RequestMethod.POST)
	public String doLogin(
			@ModelAttribute("sessionUsername") String sessionUsername
			, @RequestParam(value="username") String username
			, @RequestParam(value="passwd") String passwd
			, Model model) {
		
		//userDAO.select(id)
		UserVO userVO = userDAO.selectByUsername(username);
		if ( userVO.getPasswd().equals(passwd) ) {
			// 로그인 성공
			model.addAttribute("sessionUsername", userVO.getName());
			model.addAttribute("sessionEmail", userVO.getEmail());
			
			return "admin/users/list";
		} else
		{
			// 로그인 실패: 비밀번호가 다르니까.
			model.addAttribute("sessionUsername", "");
			model.addAttribute("sessionEmail", "");
		}
		
		return "redirect:/admin/login/login";
	}
	
	
	@RequestMapping(value = "/admin/login/logout", method = RequestMethod.GET)
	public String logout(
			@ModelAttribute("sessionUsername") String sessionUsername
			, Model model) {
		
		
		model.addAttribute("sessionUsername", "");
		model.addAttribute("sessionEmail", "");
		
		return "redirect:/admin/login/login";
	}
	@RequestMapping(value = "/admin/users/userDetail", method = RequestMethod.GET)
	public String userDetail(@RequestParam("id") int id, Locale locale, Model model) {
		UserDetailVO userDetailOne = userDetailDAO.select(id);
		model.addAttribute("userDetailOne", userDetailOne);
		return "admin/users/userDetail";
	}
}
