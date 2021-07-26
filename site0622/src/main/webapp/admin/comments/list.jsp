<%@page import="com.koreait.site0625.util.message.MessageObject"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	MessageObject msg = new MessageObject();
%>

<%
//세션에 VO가 존재하지 않는다면, 이 유저는 인증받은 적이 없다는것.
//이를 이용해 페이지 접근을 막하보자
if(session.getAttribute("member")==null){
	out.print(msg.getMsgBack("로그인이 필요한 서비스입니다"));
}else{
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/admin/inc/navi.jsp" %>
댓글을 관리하는 모드..!
</body>
</html>
<%} %>