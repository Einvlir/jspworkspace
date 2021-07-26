<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>

<%!
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/javase?characterEncoding=UTF-8";
	String user = "root";
	String password = "1234";
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

%>
<%
	Class.forName(driver);//driver로드
	out.print("드라이버 로드됨..<br>");//이미 드라이버를 lib 공용 jar 디렉토리에 넣어두었다..
	con = DriverManager.getConnection(url, user, password);
	if(con==null){
		out.print("접속실패");
	}else{
		out.print("접속성공<br>");
		String sql = "select * from member";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		out.print(rs);
		

	}
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}
</style>
</head>
<body>

<h2>Zebra Striped Table</h2>
<p>For zebra-striped tables, use the nth-child() selector and add a background-color to all even (or odd) table rows:</p>

<table>
	<tr>
		<th>No</th>
		<th>member_id</th>
		<th>user_id</th>
		<th>name</th>
		<th>regdate</th>
	</tr>
	<%while(rs.next()){%>
	<tr>
		<td>Jill</td>
		<td><%=rs.getInt("member_id")%></td>
		<td><%=rs.getString("user_id")%></td>
		<td><%=rs.getString("name")%></td>
		<td><%=rs.getString("regdate")%></td>
	</tr>
	<%}%>
</table>

</body>
</html>
<%
		rs.close();
		pstmt.close();
		con.close();
%>