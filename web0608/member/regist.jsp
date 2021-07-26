<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>

<%!
//[2]선언부 영역, 멤버 영역과 같다.. 멤버변수와 멤버메서드 정의!
	String url="jdbc:mysql://localhost:3306/javase?characterEncoding=UTF-8";
	String user = "root";
	String pass = "1234";
	Connection con;
	PreparedStatement pstmt;
%>

<%
//[3]스크립틀릿 영역
//메서드에 작성한 코드로 간주된다..jsp에서 사용할 주요 로직을 여기서 작성한다.
//클라이언트가 전송한 파라미터들을 regist.jsp를 요청할 때 전송한 파라미터를 받아보자..
//jsp는 기본적으로 개발자가 생성하지 않아도 기본적으로 시스템에 의해 생성된 객체를 지원한다.
//특히 클라이언트가 전송한 요청작업은 request를 이용..
	request.setCharacterEncoding("utf-8");
	String user_id = request.getParameter("user_id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");

	out.print(user_id+"<br>");
	out.print(password+"<br>");
	out.print(name);
	//jsp
	Class.forName("com.mysql.jdbc.Driver");
	
	con = DriverManager.getConnection(url, user, pass);
	if(con==null){
		out.print("접속에러<br>");
	}else{
		out.print("성공<br>");
		String sql = "insert into member(user_id, password, name) values(?,?,?)";
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, user_id);
		pstmt.setString(2, password);
		pstmt.setString(3, name);

		int result = pstmt.executeUpdate();
		if(result <1){
			out.print("error");
		}else{
			out.print("success");
		}
		con.close();
	}
	
%>