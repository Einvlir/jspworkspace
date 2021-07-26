<%@ page contentType="text/html;charset=UTF-8"%>
<%
	request.setAttribute("msg1", "요청객체애오");
	session.setAttribute("msg2", "세션이애오");
	application.setAttribute("msg3", "어플리캐이션이애오");
%>
<a href="/result.jsp">심었어용</a>