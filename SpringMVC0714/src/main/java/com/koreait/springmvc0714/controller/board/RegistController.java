package com.koreait.springmvc0714.controller.board;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc0714.exception.DMLException;
import com.koreait.springmvc0714.model.board.service.BoardService;
import com.koreait.springmvc0714.model.domain.Board;

import lombok.Setter;

//게시물 등록 요청을 처리할 하위 컨트롤러
@Setter
public class RegistController implements Controller{
	private BoardService boardService;
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Board board = new Board();
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));

		ModelAndView mav = new ModelAndView();

		try {
			boardService.insert(board);
			System.out.println("등록 성공!");
			mav.setViewName("redirect:/board/list");
		}catch(DMLException e){
			e.printStackTrace();
			System.out.println("등록 시 에러 발생");
			mav.addObject("e", e);
			mav.setViewName("error/result");
		}
		
		return mav;
	}
	
}
