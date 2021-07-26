package com.koreait.springdb.model.service.board;

import java.util.List;

import com.koreait.springdb.model.domain.Board;

public interface BoardService {
	public List selectAll();
	public void regist(Board board);
	public Board select(int board_id);
	public void update(Board board);
	public void delete(int board_id);
}
