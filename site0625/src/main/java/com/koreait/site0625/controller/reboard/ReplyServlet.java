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

public class ReplyServlet extends HttpServlet{
	ReBoardDAO reBoardDAO;
	MessageObject obj;
	
	@Override
	public void init() throws ServletException {
		reBoardDAO = new MybatisReBoardDAO();
		obj = new MessageObject();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int team = Integer.parseInt(request.getParameter("team"));
		int step = Integer.parseInt(request.getParameter("step"));
		int depth = Integer.parseInt(request.getParameter("depth"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		//vo
		ReBoard reBoard = new ReBoard();
		reBoard.setTeam(team);
		reBoard.setStep(step);
		reBoard.setDepth(depth);
		reBoard.setTitle(title);
		reBoard.setWriter(writer);
		reBoard.setContent(content);
		
		
		
		//답변 등록을 위한 메서드 호출(자리확보 + 답변등록)
		int result = reBoardDAO.reply(reBoard);
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(result == 0) {
			out.print(obj.getMsgBack("으악 오류"));
		}else {
			out.print(obj.getMsgURL("성공 ^^", "/reboard/list.jsp"));
		}
		
		
	}
}
