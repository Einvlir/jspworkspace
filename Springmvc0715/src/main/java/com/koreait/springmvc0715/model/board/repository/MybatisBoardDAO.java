package com.koreait.springmvc0715.model.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.springmvc0715.exception.DMLException;
import com.koreait.springmvc0715.model.domain.Board;

import lombok.Setter;
@Setter
@Repository
public class MybatisBoardDAO implements BoardDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List selectAll() {
		List boardList = sqlSessionTemplate.selectList("Board.selectAll");
		return boardList;
	}
	
	public void insert(Board board) throws DMLException{
		sqlSessionTemplate.insert("Board.insert", board);
	}

	public Board select(int board_id) {
		return sqlSessionTemplate.selectOne("Board.select",board_id);
	}

	public void update(Board board) throws DMLException{
		sqlSessionTemplate.update("Board.update",board);
	}

	public void delete(int board_id) throws DMLException{
		sqlSessionTemplate.delete("Board.delete",board_id);
	}

}
