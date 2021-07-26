<%@page import="site0616.model.domain.Board"%>
<%@page import="site0616.board.model.dao.BoardDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
	BoardDAO boardDAO = new BoardDAO();

%>
<%
	//서블릿의 service메서드에 코드를 작성하는것과 같음..
	request.setCharacterEncoding("utf-8"); // 전송중 한글처리..
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	//오라클에 넣기
	//VO생성하여 인수로 넘기기..
	Board board = new Board();
	board.setTitle(title);
	board.setWriter(writer);
	board.setContent(content);
	int result = boardDAO.insert(board);
	
	out.print("<script>");
	if(result ==0){
		out.print("alert('등록실패');");
		out.print("history.back();");
	}else{
		out.print("alert('등록성공');");
		out.print("location.href='/board/list.jsp';");
	}
	out.print("</script>");
	
%>