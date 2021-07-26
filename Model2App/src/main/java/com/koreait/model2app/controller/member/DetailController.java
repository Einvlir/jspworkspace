package com.koreait.model2app.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.domain.Member;
import com.koreait.model2app.model.member.service.MemberService;
import com.koreait.model2app.model.member.service.MemberServiceImpl;

public class DetailController implements Controller{

	MemberService memberService;
	public DetailController() {
		memberService = new MemberServiceImpl();
	}
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int member_id = Integer.parseInt(request.getParameter("member_id"));
		Member member = memberService.select(member_id);
		request.setAttribute("member", member);
	}

	public String getViewName() {
		
		return "result/member/detail";
	}

	public boolean isForward() {
		return false;
	}

}
