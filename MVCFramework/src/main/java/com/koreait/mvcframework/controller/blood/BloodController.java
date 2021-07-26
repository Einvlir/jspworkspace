package com.koreait.mvcframework.controller.blood;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvcframework.controller.Controller;
import com.koreait.mvcframework.model.blood.BloodService;

public class BloodController implements Controller{
	BloodService service;
	public BloodController() {
		service = new BloodService();
	}
	public void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//결과 받기~
		request.setCharacterEncoding("utf-8");
		String blood = request.getParameter("blood");
		
		//이미 기존에 작성해 두었던 로직을 재사용해보자
		String msg = service.getAdvice(blood);//3단계, 일시키기
		
		//원하는 변수명, 데이터. 일종의 map이라 할 수 있다!
		
		//4단계 저장
		request.setAttribute("msg", msg);
		//아래와 같이 요청을 끊고 재접속하지 않고, 서버에서 특정 자원으로 요청을 전달시키자..
		//response.sendRedirect("/blood/result.jsp?");
		
		
		
	}
	public String getViewName() {
		return "/blood/result.jsp";
	}
}
