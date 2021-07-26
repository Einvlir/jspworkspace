package com.koreait.model2app.model.board.dao;

import java.util.List;

import com.koreait.model2app.model.domain.Board;

public interface BoardDAO{
	public List selectAll();
	
	public int insert(Board board);
	
	public Board select(int board_id);
	
	public int update(Board board);
	
	public int delete(int board_id);
}
