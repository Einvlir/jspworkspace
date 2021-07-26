<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//서블릿의 service메서드에 코드를 작성하는것과 같음..
	request.setCharacterEncoding("utf-8"); // 전송중 한글처리..
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	//클라이언트에 응답할 응답정보에서 사용할 출력스트림에 문자열 인수로 넘기기..
	out.print(title+"<br>");
	out.print(writer+"<br>");
	out.print(content+"<br>");
	//오라클에 넣자
	Class.forName("oracle.jdbc.driver.OracleDriver");
	out.print("드라이버 로드됨<br>");
	
	//오라클 접속
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","webmaster","1234");
	PreparedStatement pstmt = null;
	
	if(con == null){
		out.print("실패함..<br>");
		
	}else{
		out.print("성공함..<br>");
		
		String sql = "insert into board(board_id, title, writer, content) values(seq_board.nextval,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, writer);
		pstmt.setString(3, content);
		
		int result = pstmt.executeUpdate();
		
		if(result ==0 ){
			out.print("망했슘다");
		}else{
			out.print("등록성공<br>");
			out.print("<script>");
			out.print("alert('등록성공');");
			out.print("location.href='/board/list.jsp';");
			out.print("</script>");
			
		}
		pstmt.close();
		con.close();
	}
	
%>