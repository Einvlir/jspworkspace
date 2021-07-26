<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류 페이지 !</title>
</head>
<body bgcolor="yellow">
	<img src="/images/error.png">
	<p>
	<%
		RuntimeException e=(RuntimeException)request.getAttribute("obj");
		out.print(e.getMessage());
	%>
</body>
</html>