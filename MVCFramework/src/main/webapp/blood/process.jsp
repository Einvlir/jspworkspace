<%@page import="com.koreait.model2app.model.blood.BloodService"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%!
	BloodService service = new BloodService();
%>
<% 
	//컨트롤러는 디자인과 로직을 분리시키기 위한 중간처리자이다.. 프로그램의 흐름을 처리!
	
	//결과 받기~
	request.setCharacterEncoding("utf-8");
	String blood = request.getParameter("blood");
	
	//이미 기존에 작성해 두었던 로직을 재사용해보자
	String msg = service.getAdvice(blood);
	
	//원하는 변수명, 데이터. 일종의 map이라 할 수 있다!
	request.setAttribute("msg", msg);
	//아래와 같이 요청을 끊고 재접속하지 않고, 서버에서 특정 자원으로 요청을 전달시키자..
	//response.sendRedirect("/blood/result.jsp?");
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/blood/result.jsp");
	dispatcher.forward(request, response);// 쌍방울을 가지고 result.jsp로 전달된다!
		
%>
