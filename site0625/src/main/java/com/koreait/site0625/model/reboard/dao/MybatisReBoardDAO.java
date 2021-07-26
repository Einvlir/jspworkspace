package com.koreait.site0625.model.reboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.site0625.model.domain.ReBoard;
import com.koreait.site0625.model.mybatis.MybatisConfigManager;

public class MybatisReBoardDAO implements ReBoardDAO {

	MybatisConfigManager configManager = MybatisConfigManager.getInstance();

	public int insert(ReBoard reboard) {
		SqlSession sqlSession = configManager.getSession();// 세션얻기

		System.out.println("넣기 전 reboard_id는 " + reboard.getReboard_id()); // 0

		int result = sqlSession.insert("ReBoard.insert", reboard);
		reboard.setTeam(reboard.getReboard_id());
		sqlSession.update("ReBoard.updateTeam", reboard);
		sqlSession.commit();

		System.out.println("넣은 후 reboard_id는 " + reboard.getReboard_id());// 현재 세션에서의 최신 pk

		configManager.closeSession(sqlSession);// 세션닫기
		return result;
	}


	
	public List selectAll() {
		SqlSession sqlSession = configManager.getSession();
		List list = sqlSession.selectList("ReBoard.selectAll");
		configManager.closeSession(sqlSession);
		return list;
	}

	public ReBoard select(int reboard_id) {
		SqlSession sqlSession = configManager.getSession();
		ReBoard reboard = sqlSession.selectOne("ReBoard.select",reboard_id);
		configManager.closeSession(sqlSession);
		return reboard;
	}

	@Override
	public int update(ReBoard reboard) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int reboard_id) {
		// TODO Auto-generated method stub
		return 0;
	}

//	//답변이 들어갈 자리 확보
//	public int updateStep(ReBoard reboard) {
//		SqlSession sqlSession = configManager.getSession();
//		int result = sqlSession.update("ReBoard.updateStep",reboard);
//		sqlSession.commit();
//		configManager.closeSession(sqlSession);
//		return result;
//	}

	//답변등록
	public int reply(ReBoard reboard) {
		SqlSession sqlSession = configManager.getSession();
		int result=0;
		
		try {
			sqlSession.update("ReBoard.updateStep",reboard);
			sqlSession.update("ReBoard.reply",reboard);
			sqlSession.commit();
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		configManager.closeSession(sqlSession);
		return result;
		
	}

}
