package com.koreait.site0622.controller.comments;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.site0622.model.comments.dao.CommentsDAO;
import com.koreait.site0622.model.comments.dao.JdbcCommentsDAO;
import com.koreait.site0622.model.comments.dao.MybatisCommentsDAO;
import com.koreait.site0622.model.domain.Comments;
//클라이언트의 요청이 비동기방식이므로 디자인을 결과로 보내서는 안 된다.. 데이터만!
public class RegistServlet extends HttpServlet{
	
	CommentsDAO commentsDAO;
	
	@Override
	public void init() throws ServletException {
		//commentsDAO = new JdbcCommentsDAO();
		commentsDAO = new MybatisCommentsDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//파받
		String msg = request.getParameter("msg");
		String cwriter = request.getParameter("cwriter");
		int news_id = Integer.parseInt(request.getParameter("news_id"));
		
		//VO에 담기
		Comments comments = new Comments();
		comments.setMsg(msg);
		comments.setCwriter(cwriter);
		comments.setNews_id(news_id);
		
		//DAO일
		int result = commentsDAO.insert(comments);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
	}
}
