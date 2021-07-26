package com.koreait.site0622.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.site0622.model.domain.Member;
import com.koreait.site0622.model.member.dao.MemberDAO;
import com.koreait.site0622.model.member.dao.MybatisMemberDAO;
import com.koreait.site0622.util.message.MessageObject;

//아이디 중복 쳌 전용..
public class CheckIdServlet extends HttpServlet{
	MemberDAO memberDAO;
	MessageObject MessageObject;
	@Override
	public void init() throws ServletException {
		memberDAO = new MybatisMemberDAO();
		MessageObject = new MessageObject();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 넘겨받기, member테이블에 이미 존재하는지?
		String user_id = request.getParameter("user_id");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Member member = memberDAO.getMemberById(user_id);//다형성
		
//		if(member == null) {
//			out.print(MessageObject.getMsgURL("사용가능합니다 ^^", "/member/signup.jsp"));
//		}else {
//			out.print(MessageObject.getMsgBack("이미 사용중인 ID 입니다"));
//		}
		
		//비동기식 응답 정보 보내기
		if(member==null) {
			out.print(0);
		}else {
			out.print(1);
		}
	}
}
