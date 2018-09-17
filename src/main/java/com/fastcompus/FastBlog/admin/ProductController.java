package com.fastcompus.FastBlog.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fastcompus.FastBlog.dao.ProductDAO;
import com.fastcompus.FastBlog.vo.ProductVO;
import com.fastcompus.FastBlog.vo.UserDetailVO;
import com.fastcompus.FastBlog.vo.UserVO;

@Controller
@SessionAttributes({"sessionUsername","sessionEmail"})
public class ProductController {
private static final Logger logger = LoggerFactory.getLogger(ProductController.class);	
	
	@Autowired
	private ProductDAO productDAO;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/products/list", method = RequestMethod.GET)
	public String list(
			@ModelAttribute("sessionUsername") String sessionUsername
			, @ModelAttribute("sessionEmail") String sessionEmail
			, Model model) {
	
	if ( sessionUsername.equals("") ) {
		return "redirect:/admin/login/login";
	}
		List<ProductVO> productList = productDAO.selectList();
		model.addAttribute("productList", productList);
		
		System.out.println(productList.get(0).getId());
		System.out.println(productList.get(0).getName());
		System.out.println(productList.get(0).getPrice());
		
		return "admin/products/list";
	}
	
	
	@RequestMapping(value = "/admin/products/add", method = RequestMethod.GET)
	public String add(
			@ModelAttribute("sessionUsername") String sessionUsername
			, Model model) {
		
		return "admin/products/add";
	}
	
	@RequestMapping(value = "/admin/products/doAdd", method = RequestMethod.POST)
	public String doAdd  (
			@RequestParam(value="name") String name
			, @RequestParam(value="price") int price
			,@RequestParam("file") MultipartFile file
			, @ModelAttribute("sessionUsername") String sessionUsername
			
			, Model model) throws IOException {
		
		// Save file on system
	      if (!file.getOriginalFilename().isEmpty()) {
	         BufferedOutputStream outputStream = new BufferedOutputStream(
	               new FileOutputStream(
	                     new File("C:\\Users\\cjswo\\Downloads", file.getOriginalFilename())));
	         
	         System.out.println(model);
	         
	         ProductVO productVO = new ProductVO();
	         productVO.setName(name);
	         productVO.setPrice(price);
	         productVO.setCompanysId(1);
	         productVO.setImgUrl(file.getOriginalFilename());
	         
	         productDAO.insert(productVO);
	         
	         outputStream.write(file.getBytes());
	         outputStream.flush();
	         outputStream.close();
	      } 
	      
		return "admin/products/doAdd";

	}

}
