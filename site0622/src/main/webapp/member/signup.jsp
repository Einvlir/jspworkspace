<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<script type="text/javascript">
var valid=false;
$(function(){
	$("#bt_check").click(function(){
		checkId();
	});
	$("#bt_regist").click(function(){
		regist();
	});
});
//회원 가입 전에 아이디 중복 여부를 쳌
function checkId(){
	//동기방식으로 하게 되면 메인실행부가 대기상태에 빠지거나 넘겨받은 컨텐츠로 화면 전체를 갱신하기 때문에
	//새로고침 효과가 일어나버린다 따라서 이를 해결하기 위해 별도의 비동기객체로 하여금
	//서버와 통신을 담당하게 하고 컨텐츠를 메인 실행부에 전달하여 메인실행부는 이 컨텐츠를
	//DOM을 이용한 접근방법으로 HTML의  일부만 수정하면 되기 때문에 전체페이지를 갱신하지 않는다.
	/*
	$("form").attr({
		"action" : "/member/idcheck",
		"method" : "post"
	});
	$("form").submit();
	*/
	//순수한 비동기객체인 XMLHttpRequest를 직접사용할 수도 있으나 처리 코드가 너무 번잡해
	//자바스크립트르 단순화 시킨 jquery의 ajax기능을 활용해보자
	$.ajax({
		url:"/member/idcheck",
		type:"post",
		data:{
			"user_id":$("input[name='user_id']").val()
		},
		success:function(result,status,xhr){//서버 응답정보, 서버상태코드(ex/404..200..), 비동기통신객체
			if(result==1){
				alert("이미 사용중인 아이디입니다.");
				valid=false;
			}else{
				alert("사용가능한 아이디입니다.");
				valid=true;
			}
		},
		error:function(xhr,status,error){//서버의 상태코드가 error일때 동작..
			
		}
	});
}

function regist(){
	if(valid){
		$("form").attr({
			"action":"/member/regist.jsp",
			"method":"post"
		});
		$("form").submit();
		
	}else{
		alert("아이디 중복확인을 해 주세요");
	}
}
</script>
</head>
<body>

<h3>회원가입</h3>

<div class="container">
  <form>
    <input type="text" name="user_id" placeholder="Your Id">
    <input type="button" value="ID중복 확인" id = "bt_check">
    <input type="text" name="password" placeholder="Your Password">
    <input type="text" name="name" placeholder="Your Name..">
    <input type="button" value="회원등록" id = "bt_regist">
  </form>
</div>

</body>
</html>
