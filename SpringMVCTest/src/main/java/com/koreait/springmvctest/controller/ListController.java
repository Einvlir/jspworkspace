package com.koreait.springmvctest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvctest.model.board.dao.BoardDAO;

public class ListController implements Controller{
	private BoardDAO boardDAO;
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List boardList = boardDAO.selectAll();//3단계
		
		//결과 저장 + 뷰 이름까지 포함
		ModelAndView mav = new ModelAndView();//4단계
		mav.addObject("boardList",boardList);
		mav.setViewName("board/list");
		return mav;
	}

}
