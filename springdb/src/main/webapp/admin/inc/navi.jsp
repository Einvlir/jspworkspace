<%@page import="com.koreait.site0622.model.domain.Member"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #04AA6D;
  color: white;
}
</style>
<%
	Member member = (Member)session.getAttribute("member");
	
%>
<%=member.getName() %>
<div class="topnav">
  <a class="active" href="#home">Home</a>
  <a href="/admin/member/list.jsp">회원관리</a>
  <a href="/admin/comments/list.jsp">코멘트게시판</a>
  <a href="#">로그아웃</a>
</div>