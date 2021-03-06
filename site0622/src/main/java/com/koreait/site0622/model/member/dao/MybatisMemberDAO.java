package com.koreait.site0622.model.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.site0622.model.domain.Member;
import com.koreait.site0622.model.mybatis.MybatisConfigManager;

public class MybatisMemberDAO implements MemberDAO{
	MybatisConfigManager configManager = MybatisConfigManager.getInstance();
	
	public Member getMemberById(String id) {
		SqlSession sqlSession = configManager.getSession();
		Member member = sqlSession.selectOne("Member.getMemberById", id);
		configManager.closeSession(sqlSession);
		return member;
	}

	public int regist(Member member) {
		SqlSession sqlSession = configManager.getSession();
		int result = sqlSession.insert("Member.regist", member);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		return result;
	}

	public int delete(Member member) {
		return 0;
	}

	public List selectAll() {
		return null;
	}

	public Member select(int member_id) {
		return null;
	}

	public Member select(Member member) {
		SqlSession sqlSession = configManager.getSession();
		Member obj = sqlSession.selectOne("Member.loginCheck",member);
		configManager.closeSession(sqlSession);
		return obj;
	}
	public int update(Member member) {
		return 0;
	}

}
