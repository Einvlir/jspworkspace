<%@page import="com.koreait.site0622.model.domain.News"%>
<%@page import="com.koreait.site0622.model.news.dao.NewsDAO"%>
<%@page import="com.koreait.site0622.model.news.dao.MybatisNewsDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!NewsDAO newsDAO = new MybatisNewsDAO(); %>
<%
	int news_id = Integer.parseInt(request.getParameter("news_id"));
	News news = newsDAO.select(news_id);
%> 
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=button] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=button]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.ckeditor.com/4.16.1/standard/ckeditor.js"></script>
<script src="https://unpkg.com/react@16/umd/react.production.min.js"></script>
<script src="https://unpkg.com/react-dom@16/umd/react-dom.production.min.js"></script>
<script src="https://unpkg.com/babel-standalone@6.15.0/babel.min.js"></script>
<script type="text/babel">

</script>

<script src= "/js/Comments.js"></script>
<script type="text/babel">

	class CustomComments extends React.Component{
		render(){
			//반복문 등 처리 할 때..
			//return 영역 밖에서 원하는 태그를 구성한 후 완성된 태그를 return안에서 사용하면 됨..
			var tag = [];
			for(var i = 0 ; i < this.props.result.commentsList.length; i++){
				var obj = this.props.result.commentsList[i];
				tag.push(
					<div>
						<input type = "text" value={obj.msg} style={{width:"75%"}}/>
						<input type = "text" value={obj.cwriter} style={{width:"15%"}}/>
						<input type = "text" value={obj.cdate} style={{width:"8%"}}/>
					</div>
				);
			}
			return <div>
						{tag}
					</div>
		}	
	}	
//수정요청
$(function(){
	
	

	CKEDITOR.replace("content");
	
	var bt_list=$("input[type='button']")[0];
	var bt_edit=$("input[type='button']")[1];
	var bt_del=$("input[type='button']")[2];
	
	$(bt_list).click(function(){
		location.href="/news/list.jsp";
	});
	$(bt_edit).click(function(){
		
	});
	$(bt_del).click(function(){
		
	});
	getCommentsList();
});
function edit() {
	$("#form1").attr({
		"action":"",
		"method":"POST"
	});
	$("#form1").submit();
}
//댓글 등록
function registComments(){
	var formdata = $("#form2").serialize();
	
	$.ajax({
		url:"/comments/regist",
		type:"POST",
		data:formdata,
		success:function(result, status, xhr){
			if(result ==1 ){
				getCommentsList();
				
			}
		}
	});
}
function getCommentsList(){
	//비동기요청
	$.ajax({
		url:"/comments/list?news_id=<%=news.getNews_id()%>",
		type:"get",
		success:function(result, status, xhr){
			
			console.log(result.commentsList.length);
			//printCommentsList3(result);

			ReactDOM.render(<CustomComments result={result}/> , document.getElementById("commentsArea"));

		}
	});
}
//댓글목록 출력하기
function printCommentsList(json){
	//기존의 commentsArea의 컨텐츠 초기화
	$("#commentsArea").html("");
	
	var tag = "";
	for(var i = 0; i < json.commentsList.length; i++){
		var comments = json.commentsList[i];
		tag += "<div>"
		tag += "<input type = 'text' value = '"+comments.msg+"' style='width:75%' readonly>" ;
		tag += "<input type = 'text' value = '"+comments.cwriter+"' style='width:15%' readonly>" ;
		tag += "<input type = 'text' value = '"+comments.cdate+"' style='width:8%' readonly>" ;
		tag += "</div>"
	}
	$("#commentsArea").append(tag);
}
//출력대상이 되는 tag를 객체로 처리해보자
function printCommentsList2(json){
	$("#commentsArea").html("");
	for(var i = 0; i<json.commentsList.length;i++){
		var obj=json.commentsList[i];
		var comments = new Comments(document.getElementById("commentsArea"),obj.msg, obj.cwriter, obj.cdate);
	}
}

</script>

</head>
<body>

<h3>상세보기</h3>

<div class="container">
  <form id = "form1">
	<input type="hidden" name = "news_id" value = "<%=news.getNews_id()%>">
    <input type="text" name="title" 	value="<%=news.getTitle() %>">
    <input type="text" name="writer" value="<%=news.getWriter()%>">
    <textarea name="content" 	 style="height:200px"><%=news.getContent() %></textarea>

    <input type="button" value="목록">
    <input type="button" value="수정">
    <input type="button" value="삭제">
  </form>
</div>
<div>
	<form id = "form2">
		<input type="hidden" name = "news_id" value = "<%=news.getNews_id()%>">
		<input type="text" name = "msg" placeholder="메시지" style="width: 75%">
		<input type="text" name = "cwriter" placeholder="작성자" style="width: 15%">
	    <input type="button" value="댓글등록" style="width: 8%" onClick="registComments()">
	</form>
</div>

<div id = "commentsArea">
	
</div>

</body>
</html>