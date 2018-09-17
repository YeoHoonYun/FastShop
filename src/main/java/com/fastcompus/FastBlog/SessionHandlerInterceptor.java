package com.fastcompus.FastBlog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionHandlerInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		
		if ( session.getAttribute("sessionUsername") == null ) {
			response.sendRedirect("/admin/login/login");
			return false;
		};
		System.out.println("���ͼ��Ϳ��� �α���");
		return true;
	}

}