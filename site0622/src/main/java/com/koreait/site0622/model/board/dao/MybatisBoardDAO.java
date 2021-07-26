package com.koreait.site0622.model.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.site0622.model.board.domain.Board;
import com.koreait.site0622.model.mybatis.MybatisConfigManager;

//mybatis를 이용한다고 DAO가 사라지는것은 아니다..
//단 DAO가 사용하려는 기술이 JDBC인가 Mybatis인가 JPA인가 등등에 따라 달라질 뿐..
public class MybatisBoardDAO implements BoardDAO{
	MybatisConfigManager configManager = MybatisConfigManager.getInstance();
	public int insert(Board board) {
		SqlSession sqlSession = configManager.getSession();
		
		
		int result = sqlSession.insert("Board.insert",board);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		return result;
	}
	public List selectAll() {
		SqlSession sqlSession = configManager.getSession();
		List list = sqlSession.selectList("Board.selectAll");
		configManager.closeSession(sqlSession);
		return list;
	}
	//레코드 한건 가져오기!
	public Board select(int board_id) {
		SqlSession sqlSession = configManager.getSession();
		Board board =  sqlSession.selectOne("Board.select",board_id);
		configManager.closeSession(sqlSession);
		return board;
	}
	
	public int update(Board board) {
		SqlSession sqlSession = configManager.getSession();
		int result = sqlSession.update("Board.update",board);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		return result;
		
	}
	public int delete(int Board_id) {
		SqlSession sqlSession = configManager.getSession();
		int result = sqlSession.delete("Board.delete", Board_id);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		return result;
	}
}
