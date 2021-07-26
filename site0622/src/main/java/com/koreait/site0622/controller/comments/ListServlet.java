package com.koreait.site0622.controller.comments;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.site0622.model.comments.dao.CommentsDAO;
import com.koreait.site0622.model.comments.dao.JdbcCommentsDAO;
import com.koreait.site0622.model.domain.Comments;

//댓글 목록 요청을 처리하는 서블릿
public class ListServlet extends HttpServlet{
	CommentsDAO commentsDAO;
	
	
	public void init() throws ServletException {
		commentsDAO = new JdbcCommentsDAO();
		//commentsDAO = new MybatisCommentsDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int news_id = Integer.parseInt(request.getParameter("news_id"));
		List<Comments> commentsList = commentsDAO.selectByNewsId(news_id);
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"commentsList\":[");
		for(int i = 0; i<commentsList.size();i++) {
			Comments comments = commentsList.get(i);
			sb.append("{");
			sb.append("\"comments_id\":"+comments.getComments_id()+",");
			sb.append("\"msg\":\""+comments.getMsg()+"\",");
			sb.append("\"cwriter\":\""+comments.getCwriter()+"\",");
			sb.append("\"cdate\":\""+comments.getCdate()+"\",");
			sb.append("\"news_id\":"+comments.getNews_id());
			if(i < commentsList.size()-1) {
				sb.append("},");
			}else {
				sb.append("}");				
			}
		}		
		sb.append("]");
		sb.append("}");
		
		out.print(sb.toString());

	}
}
