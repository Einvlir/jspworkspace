package com.koreait.model2app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//상위로부터 받은 요청정보를 이용하여 실제 요청을 처리
	public void execute(HttpServletRequest request, HttpServletResponse response);

	public String getViewName();//응답시 보여질 결과페이지
	public boolean isForward();
}
