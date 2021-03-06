package com.koreait.shoppingmall.controller.admin;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.shoppingmall.domain.Admin;
import com.koreait.shoppingmall.exception.MemberExistException;
import com.koreait.shoppingmall.model.service.admin.AdminService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private AdminService adminService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("msg", "관리자컨트롤러호출" );
		
		
		return "admin_result";
	}
	@RequestMapping(value = "/loginform", method = RequestMethod.GET)
	public String loginForm() {
		return "admin/login/loginform";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Admin admin,HttpSession session) {
		logger.info("이름은 {}",admin.getHost_id());
		Admin obj = adminService.login(admin); 	
		session.setAttribute("admin",obj);
		return "admin/main/index";
	}
	
	//위 요청을 처리하는 중 어느 하나라도 오류가 발생하면 아래의 메서드가 동작한다.
	@ExceptionHandler(MemberExistException.class)
	public String handleException(MemberExistException e, Model model) {
		model.addAttribute("e",e);
		return "error/result";
	}
}
