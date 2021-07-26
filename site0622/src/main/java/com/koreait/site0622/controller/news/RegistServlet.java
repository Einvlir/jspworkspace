package com.koreait.site0622.controller.news;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.site0622.model.domain.News;
import com.koreait.site0622.model.news.dao.MybatisNewsDAO;
import com.koreait.site0622.model.news.dao.NewsDAO;
import com.koreait.site0622.util.message.MessageObject;

//뉴스기사 등록 요청처리..
public class RegistServlet extends HttpServlet{
	NewsDAO newsDAO;
	MessageObject messageObject;
	
	public void init() throws ServletException {
		newsDAO = new MybatisNewsDAO();
		messageObject = new MessageObject();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		//VO에 담자!
		News news = new News();
		news.setTitle(title);
		news.setWriter(writer);
		news.setContent(content);
		
		//DAO일해라
		int result = newsDAO.insert(news);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(result == 0) {
			out.print(messageObject.getMsgBack("망함"));
		}else {
			out.print(messageObject.getMsgURL("잘됨", "/news/list.jsp"));
		}
	}
}
