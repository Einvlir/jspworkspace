<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	function requestByGet() {
		$.ajax({
			url:"/rest/member",
			type:"get",
			success:function(result,status,xhr){
				console.log(result);
			}
		});
	}
	function requestByGet2() {
		$.ajax({
			url:"/rest/member/56",
			type:"get",
			success:function(result,status,xhr){
				console.log(result);
			}
		});
	}
	function requestByPost() {
		var param = {
			member_id:$("input[name='member_id']").val(),	
			user_id:$("input[name='user_id']").val(),	
			pass:$("input[name='pass']").val(),	
			name:$("input[name='name']").val()	
		};
		//전송 시 개발자가 아무것도 명시하지 않으면 디폴트는 일반문자열 데이터로 전송한다..
		
		$.ajax({
			url:"/rest/member",
			type:"post",
			data:JSON.stringify(param),
			contentType:"application/json;charset=utf-8",
			success:function(result,status,xhr){
				console.log(result);
			}
		});
	}
	function requestByPut() {
		var param = {
				member_id:$("input[name='member_id']").val(),	
				user_id:$("input[name='user_id']").val(),	
				pass:$("input[name='pass']").val(),	
				name:$("input[name='name']").val()	
			};
		$.ajax({
			url:"/rest/member",
			type:"put",
			data:JSON.stringify(param),
			contentType:"application/json;charset=utf-8",
			success:function(result,status,xhr){
				console.log(result);
			}
		});
	}
	function requestByDelete() {
		var param = {
				member_id:$("input[name='member_id']").val(),	
				user_id:$("input[name='user_id']").val(),	
				pass:$("input[name='pass']").val(),	
				name:$("input[name='name']").val()	
			};
		$.ajax({
			url:"/rest/member",
			type:"delete",
			data:JSON.stringify(param),
			contentType:"application/json;charset=utf-8",
			success:function(result,status,xhr){
				console.log(result);
			}
		});
		
	}
</script>
</head>
<body>
<h2>REST 클라이언트 (form으로 요청..)</h2>
<pre>
<form id="form1">
	<input type="hidden" name="_method" value="delete">
	<input type="text" name="member_id" placeholder="member_id">
	<input type="text" name="user_id" placeholder="user_id">
	<input type="text" name="pass" placeholder="pass 입력">
	<input type="text" name="name" placeholder="name">

</form>
</pre>
	<button type="button" onclick="requestByGet()">Get</button>
	<button type="button" onclick="requestByGet2()">Get(1건)</button>
	<button type="button" onclick="requestByPost()">Post</button>
	<button type="button" onclick="requestByPut()">Put</button>
	<button type="button" onclick="requestByDelete()">Delete</button>
</body>
</html>