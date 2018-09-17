package com.fastcompus.FastBlog.admin;

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
import org.springframework.web.bind.annotation.SessionAttribute;
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
				@RequestParam(value="username", defaultValue="") String username
				, @RequestParam(value="id", defaultValue="0") int id
				, Model model) {
		
		List<UserVO> userList = userDAO.selectList();

		model.addAttribute("userList", userList);
		
		return "admin/users/list";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/users/info", method = RequestMethod.GET)
	public String info(
			 @RequestParam(value="id") String id
			, @RequestParam(required=false, value="username") String username
			, Model model) {
		
		UserVO user = userDAO.select(id);
		
		model.addAttribute("userVO", user);		
		return "admin/users/info";
	}
	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/users/edit", method = RequestMethod.GET)
	public String edit(
			@RequestParam(value="id") String id
			, @RequestParam(required=false, value="username") String username
			, Model model) {
		
		UserVO user = userDAO.select(id);
		
		model.addAttribute("userVO", user);
		
		return "admin/users/edit";
	}
	
	
	@RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
	public String add(
			Model model) {
		
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
	public String doEdit(
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
			@SessionAttribute(required=false, value="sessionUsername") String sessionUsername
			, Model model) {
		
		if(sessionUsername == null || sessionUsername.equals("")) {
			return "admin/login/login";
			
		}else {
			// 로그인이 되어 있는 상태
			return "redirect:/admin/users/list";
		}
	
		//return "admin/login/login";
	}
	@RequestMapping(value = "/admin/login/relogin", method = RequestMethod.GET)
	public String relogin(
			@SessionAttribute(required=false, value="sessionUsername") String sessionUsername
			, Model model) {
	
		
		return "admin/login/relogin";
	}
	@RequestMapping(value = "/admin/login/doLogin", method = RequestMethod.POST)
	public String doLogin(
			@SessionAttribute(required=false, value="sessionUsername") String sessionUsername
			, @RequestParam(value="username") String username
			, @RequestParam(value="passwd") String passwd
			, Model model) {
		
		//userDAO.select(id)
		UserVO userVO = userDAO.selectByUsername(username);
		if(userVO == null) {
			return "admin/login/relogin";
		}
		
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
