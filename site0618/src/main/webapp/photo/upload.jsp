<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	
	request.setCharacterEncoding("utf-8");
	
	
	String path = "E:/korea202102_jspworkspace/site0618/src/main/webapp/data";
	MultipartRequest multi = new MultipartRequest(request,path);
	out.print("완료!");
%>