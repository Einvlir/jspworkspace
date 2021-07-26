package com.koreait.springdb.controller.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.springdb.model.domain.Board;
import com.koreait.springdb.model.service.board.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
//	@RequestMapping(value="/test", method=RequestMethod.GET)
//	public String test() {
//		System.out.println("클라이언트의 테스트 호출");
//		return null;
//	}
	@RequestMapping(value = "/board/list", method=RequestMethod.GET)
	public String getList(Model model) {
		List boardList = boardService.selectAll();
		model.addAttribute(boardList); // request에 저장.. 그래서 포워딩을 하는 것..
		
		return "user/board/list";
	}
	@RequestMapping(value = "/board/detail",method = RequestMethod.GET)
	public String getDetail(int board_id,Model model) {
		Board board = boardService.select(board_id);
		model.addAttribute(board);
		
		return "user/board/detail";
	}
	@RequestMapping(value = "/board/regist",method = RequestMethod.POST)
	public String getRegist(Board board) {
		boardService.regist(board);
		
		return "redirect:/client/board/list";
	}
	@RequestMapping(value = "/board/update",method = RequestMethod.POST)
	public String getUpdate(Board board) {
		boardService.update(board);
		return "redirect:/client/board/list";
	}
	@RequestMapping(value = "/board/delete", method = RequestMethod.POST)
	public String getDelete(int board_id) {
		boardService.delete(board_id);
		return "redirect:/client/board/list";
	}
}
