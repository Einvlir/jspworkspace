package com.koreait.springmvc0707.model.board.service;

import java.util.List;

import com.koreait.springmvc0707.model.board.repository.BoardDAO;
import com.koreait.springmvc0707.model.domain.Board;

import lombok.Setter;
@Setter
public class BoardServiceImpl implements BoardService{
	private BoardDAO boardDAO;
	public List selectAll() {
		List list = boardDAO.selectAll();
		return list;
	}

	public void insert(Board board) {
		
	}

	public Board select(int board_id) {
		return boardDAO.select(board_id);
	}

	public void update(Board board) {
		
	}

	public void delete(int board_id) {
		
	}

}
