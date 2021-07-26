package com.koreait.springmvc0714.model.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koreait.springmvc0714.exception.DMLException;
import com.koreait.springmvc0714.model.board.repository.BoardDAO;
import com.koreait.springmvc0714.model.domain.Board;

import lombok.Setter;
@Setter
@Service
public class BoardServiceImpl implements BoardService{
	private BoardDAO boardDAO;
	public List selectAll() {
		List list = boardDAO.selectAll();
		return list;
	}

	public void insert(Board board) throws DMLException {
		boardDAO.insert(board);
	}

	public Board select(int board_id) {
		return boardDAO.select(board_id);
	}

	public void update(Board board) throws DMLException{
		boardDAO.update(board);
	}

	public void delete(int board_id) {
		boardDAO.delete(board_id);
	}

}
