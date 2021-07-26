<%@page import="com.koreait.site0625.util.message.MessageObject"%>
<%@page import="com.koreait.site0622.model.member.dao.MemberDAO"%>
<%@page import="com.koreait.site0622.model.member.dao.MybatisMemberDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	MemberDAO memberDAO = new MybatisMemberDAO();
	MessageObject obj = new MessageObject();	
%>
<%
	//파라미터 넘겨받기
	request.setCharacterEncoding("utf-8");

%>
<jsp:useBean id="member" class="com.koreait.site0622.model.domain.Member"/>
<jsp:setProperty property="*" name="member"/>

<%
	//db에 넣기!
	int result = memberDAO.regist(member);
	if(result == 0){
		out.print(obj.getMsgBack("가입실패!"));
	}else{
		out.print(obj.getMsgURL("ㅊㅋㅊㅋ", "/member/login.jsp"));
	}
%>
