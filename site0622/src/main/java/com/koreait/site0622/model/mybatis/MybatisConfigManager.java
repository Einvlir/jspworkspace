package com.koreait.site0622.model.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//Mybatis의 설정파일 xml을 읽는 클래스
public class MybatisConfigManager {
	SqlSessionFactory sqlSessionFactory;
	private static MybatisConfigManager instance;
	
	private MybatisConfigManager() {
		//mybatis의 설정파일 위치
		String resource = "com/koreait/site0622/model/mybatis/config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			
			//sqlsession 객체로 개발자는 쿼리문을 수행할 수 있고 이 객체를 모아놓은 객체를 Factory라 한다!
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	public static MybatisConfigManager getInstance() {
		if(instance == null) {
			instance = new MybatisConfigManager();
		}
		return instance;
	}
	
	//쿼리 수행용 SqlSession을 반환받아 갈 수 있는 메서드 정의
	public SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
	//다 사용된 SqlSession 반납
	public void closeSession(SqlSession sqlSession) {
		sqlSession.close();
	}
}
