package com.koreait.site0622.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.site0622.model.domain.Member;
import com.koreait.site0622.model.member.dao.MemberDAO;
import com.koreait.site0622.model.member.dao.MybatisMemberDAO;
import com.koreait.site0622.util.message.MessageObject;

public class LoginServlet extends HttpServlet{
	MemberDAO memberDAO;
	MessageObject messageObject;
	
	public void init() throws ServletException {
		memberDAO = new MybatisMemberDAO();
		messageObject = new MessageObject();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(user_id+"<br>"+password);
		
		Member member = new Member();
		member.setUser_id(user_id);
		member.setPassword(password);
		
		Member obj = memberDAO.select(member);
		
		if(obj == null) {
			out.print(messageObject.getMsgBack("로그인 정보가 올바르지 않습니다."));
		}else {
			out.print(messageObject.getMsgURL("로그인 성공", "/admin/main.jsp"));
			//웹사이트 어디에서나 데이터를 참조할 수 있도록 세션 영역에 VO를 넣어두자.
			HttpSession session = request.getSession();
			//로그인 결과를 어디에서나 볼 수 있도록 VO담기
			//세션은 MAP이다.. 따라서 key-value쌍을 여러개 넣을 수 있다, 단 key는 중복될 수 없다.
			session.setAttribute("member", obj);//로그인 결과 VO를 담기!
			
		}
	}
}
