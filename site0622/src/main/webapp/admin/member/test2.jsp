<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//이 jsp를 접근하는 클라이언트에 쿠키가 존재하지 않으면
	//이 jsp에 처음 접근하는것으로 볼 수 있다.. 톰캣은 이 클라이언트에게
	//세션번호를 하나 할당하게 된다. 이 번호를 출력해보자
	
	String sessionId = session.getId();//톰캣이 발급한 세션고유번호
	out.print(sessionId);
	session.setAttribute("name", "tiger");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>