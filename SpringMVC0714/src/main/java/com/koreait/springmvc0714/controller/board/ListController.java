package com.koreait.springmvc0714.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc0714.model.board.service.BoardService;

import lombok.Setter;
@Setter
public class ListController implements Controller{
	private BoardService boardService;
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List boardList = boardService.selectAll();
		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("boardList",boardList);
		
		return mav;
	}
	
}
