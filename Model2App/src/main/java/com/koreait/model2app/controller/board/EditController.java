package com.koreait.model2app.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.board.dao.BoardDAO;
import com.koreait.model2app.model.board.dao.JdbcBoardDAO;
import com.koreait.model2app.model.board.dao.MybatisBoardDAO;
import com.koreait.model2app.model.domain.Board;

public class EditController implements Controller{
	BoardDAO boardDAO;
	public EditController() {
		//boardDAO = new MybatisBoardDAO();
		boardDAO = new JdbcBoardDAO();
	}
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String board_id = request.getParameter("board_id");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Board board = new Board();
		board.setBoard_id(Integer.parseInt(board_id));
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		boardDAO.update(board);
		//request.setAttribute("board", board);
	}

	@Override
	public String getViewName() {
		return "/result/board/edit";
	}

	@Override
	public boolean isForward() {
		return true;
	}

}
