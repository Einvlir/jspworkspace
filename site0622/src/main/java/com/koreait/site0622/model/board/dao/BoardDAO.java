package com.koreait.site0622.model.board.dao;

import java.util.List;

import com.koreait.site0622.model.board.domain.Board;

//모든 BoardDAO들이 반드시 구현해야 할 메서드 정의
public interface BoardDAO {
	public List selectAll();
	public Board select(int board_id);
	public int insert(Board board);
	public int update(Board board);
	public int delete(int Board_id);
}
