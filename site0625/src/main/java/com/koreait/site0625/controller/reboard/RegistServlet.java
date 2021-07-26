package com.koreait.site0625.controller.reboard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.site0625.model.domain.ReBoard;
import com.koreait.site0625.model.reboard.dao.MybatisReBoardDAO;
import com.koreait.site0625.model.reboard.dao.ReBoardDAO;
import com.koreait.site0625.util.message.MessageObject;

public class RegistServlet extends HttpServlet{
	ReBoardDAO reboardDAO;
	MessageObject obj;
	public void init() throws ServletException {
		reboardDAO = new MybatisReBoardDAO();
		obj = new MessageObject();
	}
	//파라미터 받기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		//VO에 담기
		ReBoard reboard = new ReBoard();
		reboard.setTitle(title);
		reboard.setWriter(writer);
		reboard.setContent(content);
		
		//쿼리 실행
		int result = reboardDAO.insert(reboard);
		
		//쿼리 수행 후 vo에는 최근에 증가된 pk가 들어있을 것이다.
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(reboard.getReboard_id());
		
		if(result==0) {
			out.print(obj.getMsgBack("등록실패"));			
		}else {
			out.print(obj.getMsgURL("등록성공!", "/reboard/list.jsp"));
		}
	}
}
