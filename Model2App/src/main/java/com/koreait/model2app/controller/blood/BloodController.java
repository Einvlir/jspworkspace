package com.koreait.model2app.controller.blood;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.blood.BloodService;

public class BloodController implements Controller{
	BloodService service;
	public BloodController() {
		service = new BloodService();
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//혈액형에 대한 판단처리
		String blood = request.getParameter("blood");
		String msg = service.getAdvice(blood);
		//결과를 저장
		request.setAttribute("msg", msg);
	}


	public String getViewName() {
		return null;
	}

	public boolean isForward() {
		return false;
	}
	

}
