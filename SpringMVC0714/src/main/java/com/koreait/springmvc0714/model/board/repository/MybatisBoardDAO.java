package com.koreait.springmvc0714.model.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.springmvc0714.exception.DMLException;
import com.koreait.springmvc0714.model.domain.Board;
import com.koreait.springmvc0714.model.mybatis.MybatisConfigManager;

import lombok.Setter;
@Setter
public class MybatisBoardDAO implements BoardDAO{
	private MybatisConfigManager configManager;
	public List selectAll() {
		SqlSession sqlSession = configManager.getSession();
		List boardList = sqlSession.selectList("Board.selectAll");
		configManager.closeSession(sqlSession);
		return boardList;
	}

	public void insert(Board board) throws DMLException{
		SqlSession sqlSession = configManager.getSession();
		int result = sqlSession.insert("Board.insert",board);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		if(result==0){
			throw new DMLException("등록 실패");
		}
	}

	public Board select(int board_id) {
		SqlSession sqlSession = configManager.getSession();
		Board board =sqlSession.selectOne("Board.select",board_id);
		configManager.closeSession(sqlSession);
		return board;
	}

	public void update(Board board) throws DMLException{
		SqlSession sqlSession = configManager.getSession();
		int result = sqlSession.update("Board.update", board);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		if(result ==0) {
			throw new DMLException("수정 실패");
		}
	}

	public void delete(int board_id) throws DMLException{
		SqlSession sqlSession = configManager.getSession();
		int result = sqlSession.delete("Board.delete", board_id);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		if(result ==0) {
			throw new DMLException("삭제 실패");
		}
		
	}

}
