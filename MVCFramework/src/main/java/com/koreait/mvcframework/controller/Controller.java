package com.koreait.mvcframework.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모든 하위 컨트롤러가 반드시 정의해야 할 메서드
public interface Controller {
	public void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;	

	//어떤 뷰를 보여줘야 하는가
	public String getViewName();
}
