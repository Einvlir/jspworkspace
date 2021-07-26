package com.koreait.site0622.model.office.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.site0622.model.mybatis.MybatisConfigManager;

public class EmpDAO {
	MybatisConfigManager configManager = MybatisConfigManager.getInstance();
	
	public List selectAll() {
		SqlSession sqlSession = configManager.getSession();
		List list = sqlSession.selectList("Emp.selectAll");
		
		return list;
	}
}
