package com.koreait.tourapp.model.store.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.tourapp.model.domain.Store;
import com.koreait.tourapp.mybatis.MybatisConfigManager;

public class MybatisStoreDAO implements StoreDAO{
	MybatisConfigManager configManager = MybatisConfigManager.getInstance();
	public int insert(Store store) {
		SqlSession sqlSession = configManager.getSession();
		int result = sqlSession.insert("Store.insert",store);
		sqlSession.commit();
		
		configManager.closeSession(sqlSession);
		return result;
	}
	public List selectAll() {
		SqlSession sqlSession = configManager.getSession();
		List list = sqlSession.selectList("Store.selectAll");
		
		configManager.closeSession(sqlSession);
		return list;
	}

	@Override
	public Store select(int select_id) {
		SqlSession sqlSession = configManager.getSession();
		Store store = sqlSession.selectOne("Store.select");
		configManager.closeSession(sqlSession);
		return store;
	}

	@Override
	public int update(Store store) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int select_id) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int lastone() {
		SqlSession sqlSession = configManager.getSession();
		int result = sqlSession.selectOne("Store.lastone");
		configManager.closeSession(sqlSession);
		return result;
	}

}
