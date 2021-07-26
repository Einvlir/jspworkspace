package com.koreait.model2app.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.board.dao.BoardDAO;
import com.koreait.model2app.model.board.dao.JdbcBoardDAO;
import com.koreait.model2app.model.board.dao.MybatisBoardDAO;

//Board의 요청 중 목록 요청을 처리하는 하위컨트롤러
public class ListController implements Controller{
	BoardDAO boardDAO;
	public ListController() {
		//boardDAO = new MybatisBoardDAO();
		boardDAO = new JdbcBoardDAO();
	}

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		List list = boardDAO.selectAll();
		
		//저장
		request.setAttribute("boardList", list);
	}

	public String getViewName() {
		
		return "/result/board/list";
	}

	@Override
	public boolean isForward() {
		return true;
	}

}
