package com.koreait.springmvc0715.model.board.repository;

import java.util.List;

import com.koreait.springmvc0715.model.domain.Board;

public interface BoardDAO {
	public List selectAll();
	public void insert (Board board);
	public Board select(int Board_id);
	public void update(Board board);
	public void delete(int Board_id);
}
