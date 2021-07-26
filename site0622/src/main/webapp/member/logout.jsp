<%@ page contentType="text/html; charset=UTF-8"%>

<%
	//현재 클라이언트가 사용 중인 session 객체를 무효화시켜보자
	//즉, 기존 세션을 더이상 사용하지 않도록 처리
	session.invalidate();

%>
<script>
alert("로그아웃 처리되었습니다.. 안녕히 가세요!");
location.href="/member/login.jsp"

</script>