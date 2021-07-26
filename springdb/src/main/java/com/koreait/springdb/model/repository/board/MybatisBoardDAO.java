package com.koreait.springdb.model.repository.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.springdb.model.domain.Board;

import lombok.Setter;
@Setter
@Repository //컴포넌트스캔의 대상.. 자동 인스턴스 생성
public class MybatisBoardDAO implements BoardDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	public List selectAll() {
		return sqlSessionTemplate.selectList("Board.selectAll");
	}

	public void insert(Board board) {
		sqlSessionTemplate.insert("Board.insert",board);
	}

	public Board select(int board_id) {
		return sqlSessionTemplate.selectOne("Board.select",board_id);
	}

	public void update(Board board) {
		sqlSessionTemplate.update("Board.update",board);
	}

	public void delete(int board_id) {
		sqlSessionTemplate.delete("Board.delete",board_id);
	}

}
