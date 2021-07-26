package com.koreait.site0622.model.mybatis;

import org.apache.ibatis.session.SqlSession;

import com.koreait.site0622.model.board.domain.Board;

public class Test {
	public static void main(String[] args) {
		//mybatis 테스트!
		MybatisConfigManager mybatisConfigManager = MybatisConfigManager.getInstance();
		
		//이미 SqlSession에는 db와 접속이 처리되어 있다..
		SqlSession sqlSession = mybatisConfigManager.getSession();
		Board board = new Board();
		board.setTitle("테스트");
		board.setWriter("tester");
		board.setContent("null");
		
		int result = sqlSession.insert("com.koreait.site0622.model.board.domain.Board.insert", board);//mybatis로 하여금 insert를  수행하라는 뜻!
		sqlSession.commit();
		if(result<1) {
			System.out.println("fail..");
		}else {
			System.out.println("success!");
		}
		mybatisConfigManager.closeSession(sqlSession);
	}
}
