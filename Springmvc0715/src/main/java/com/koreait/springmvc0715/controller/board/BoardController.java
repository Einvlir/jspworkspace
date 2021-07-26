package com.koreait.springmvc0715.controller.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.springmvc0715.model.board.service.BoardService;
import com.koreait.springmvc0715.model.domain.Board;

import lombok.Setter;
@Setter
@Controller
public class BoardController{
	@Autowired
	private BoardService boardService;//DI로 주입요청
	@RequestMapping(value="/board/list",method=RequestMethod.GET)
	public String getList(Model model) {
		List boardList = boardService.selectAll();
		model.addAttribute("boardList", boardList);
		return "board/list";//String형으로 view를 작성해서 보낼 수 있다..
	}
	@RequestMapping(value="/board/regist",method = RequestMethod.POST)
	public String regist(Board board, Model model) {
		String result;
		try {
			boardService.insert(board);
			result="redirect:/board/list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("e",e);
			result = "error/result";
		}
		
		return result;
	}
	@RequestMapping(value="/board/detail",method=RequestMethod.GET)
	public String getDetail(int board_id,Model model) {
		Board board = boardService.select(board_id);
		model.addAttribute("board",board);
		
		return "/board/detail";
	}
	@RequestMapping(value="/board/update",method=RequestMethod.POST)
	public ModelAndView edit(Board board) {
		ModelAndView mav = new ModelAndView();
		try {
			boardService.update(board);
			mav.setViewName("redirect:/board/detail?board_id="+board.getBoard_id());
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("e",e);
			mav.setViewName("error/result");
		}
		
		return mav;
	}
	@RequestMapping(value="/board/delete",method=RequestMethod.POST)
	public String delete(int board_id, Model model) {
		String viewName = null;
		try {
			boardService.delete(board_id);
			viewName = "redirect:/board/list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("e",e);
			viewName= "error/result";
		}
		return viewName;
	}
}
