package com.koreait.site0622.model.news.dao;

import java.util.List;

import com.koreait.site0622.model.domain.News;

public interface NewsDAO {
	public int insert(News news);
	public List selectAll();
	public News select(int news_id);
	//수정
	public int update(News news);
	//삭제
	public int delete(int news_id);
}
