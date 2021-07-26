package com.koreait.site0622.controller.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.site0622.model.board.dao.MybatisBoardDAO;
import com.koreait.site0622.model.board.domain.Board;
import com.koreait.site0622.util.message.MessageObject;

public class EditServlet extends HttpServlet{
	MybatisBoardDAO boardDAO;
	MessageObject messageObject;
	
	public void init() throws ServletException {
		boardDAO= new MybatisBoardDAO();
		messageObject = new MessageObject();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받고 db에 update
		request.setCharacterEncoding("utf-8");//파라미터를 인코딩
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String board_id = request.getParameter("board_id");
		//넘겨받은 파라미터를 Vo에 담자~
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		board.setBoard_id(Integer.parseInt(board_id));
		
		//DAO 일해라
		int result = boardDAO.update(board);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		if(result>0) {
			out.print(messageObject.getMsgURL("수정성공", "/board/detail.jsp?board_id="+board_id));
		}else {
			out.print(messageObject.getMsgBack("수정실패"));
		}
	}
}
