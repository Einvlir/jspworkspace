<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<pre>
		앞으로는 자바 코드 안에 DBMS에 대한 접속 정보가 없기 때문에 현재 사용중인
		웹서버가 제공하는 JNDI를 이용하여 커넥션을 취득해보자~
	</pre>
	<%
		InitialContext ctx = new InitialContext();//jndi로 검색을 실시하는 객체
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jndi/oracle");
		//이 시점부터 커넥션 풀링 객체를 보유한 것..!
		Connection con = ds.getConnection();//풀로부터 커넥션 하나 대여..
		PreparedStatement pstmt = con.prepareStatement("select count(*) as cnt from board");
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int total = rs.getInt("cnt");
		out.print(total);
		
		con.close();
	%>
</body>
</html>