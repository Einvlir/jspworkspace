package com.koreait.model2app.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.exception.LicenseRegistException;
import com.koreait.model2app.model.domain.Member;
import com.koreait.model2app.model.member.service.MemberService;
import com.koreait.model2app.model.member.service.MemberServiceImpl;
import com.koreait.model2app.util.FileManager;

public class RegistController implements Controller{
	MemberService memberService;
	FileManager fileManager;
	String viewName; // 페이지 값을 담을 변수...
	boolean forward;
	public RegistController() {
		memberService = new MemberServiceImpl();
	}

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Member member = fileManager.saveFile(request);//파일 업로드
		
		try {
			memberService.regist(member,request);
			viewName = "/result/member/regist";
			forward = false; // 리스트로 재접속
		} catch (LicenseRegistException e) {
			viewName = "/result/error";
			forward = true;// 에러페이지로 결과전송
			
			//결과 저장
			request.setAttribute("obj", e);
		}
		
	}

	public String getViewName() {
		
		return viewName;
	}

	public boolean isForward() {
	
		return forward;
	}

}
