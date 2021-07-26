
<%@page import="site0616.model.domain.Board"%>
<%@page import="site0616.board.model.dao.BoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	BoardDAO boardDAO = new BoardDAO();
%>
<%
//이 jsp는 디자인이 필요 없고, 단지 수정과 관련된 db연동만 하면 된다~
	request.setCharacterEncoding("utf-8");//한글깨짐 방지
	
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	String board_id = request.getParameter("board_id");
	
	Board board = new Board();
	board.setTitle(title);
	board.setWriter(writer);
	board.setContent(content);
	board.setBoard_id(Integer.parseInt(board_id));
	
	int result = boardDAO.update(board);
	out.print("<script>");
	if(result==0){
		out.print("alert('수정실패');");
		out.print("history.back();");
	}else{
		out.print("alert('수정성공');");
		out.print("location.href='/board/detail.jsp?board_id="+board_id+"';");
	}
	out.print("</script>");
	
%>	