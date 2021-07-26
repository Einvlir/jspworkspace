package com.koreait.springdb.model.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.koreait.springdb.model.domain.Board;
import com.koreait.springdb.model.repository.board.BoardDAO;

import lombok.Setter;
@Setter
@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	@Qualifier("mybatisBoardDAO")
	private BoardDAO boardDAO;
	
	@Override
	public List selectAll() {
		return boardDAO.selectAll();
	}

	@Override
	public void regist(Board board) {
		boardDAO.insert(board);
		
	}

	@Override
	public Board select(int board_id) {
		
		return boardDAO.select(board_id);
	}

	@Override
	public void update(Board board) {
		boardDAO.update(board);
	}

	@Override
	public void delete(int board_id) {
		boardDAO.delete(board_id);
	}

}
