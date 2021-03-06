<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}
.topnav {
	overflow: hidden;
	background-color: #808080;
	text-align: right;
}
.mid {
	display: flex;
	overflow: hidden;
	
	height: 200px;
	align-items: center;
	background-color: white;
}
.mid a {
	text-align: center;
	float: left;
	background-color: white;
}
.topnav a.bt {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 10px 16px;
	text-decoration: none;
	font-size: 12px;
}
.btn {
	float: left;
	background: #808080;
	color: white;
	text-align: center;
	padding: 10px 16px;
	text-decoration: none;
	font-size: 12px;
	border: 0;
	outline: 0;
}
.topnav a:hover {
	background-color: #C0C0C0;
	font: bold;
	color: black;
}
.topnav a.active {
	float: left;
	color: #f2f2f2;
	text-align: center;
	background-color: #000000;
	color: white;
	text-align: center;
}
body {
	margin: 0;
	font-size: 28px;
	font-family: Arial, Helvetica, sans-serif;
}
#navbar {
	overflow: hidden;
	background-color: rgb(245,245,245,0.7);
}
#navbar a {
	float: left;
	display: block;
	color: black;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}
#navbar button {
	float: left;
	display: block;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
	background-color: rgb(51,51,51,0.7);
	color: white;
}
#navbar a:hover {
	background-color: #ddd;
	color: black;
}
#navbar a.active {
	background-color: rgb(51,51,51,0.7);
	color: white;
}
#searchbar{
	border-radius: 8px;
}
.content {
	padding: 16px;
}
.sticky {
	position: fixed;
	top: 0;
	width: 100%;
	float:none;
}
.sticky+.content {
	padding-top: 60px;
}
#topnav-L{
	margin-left: 30px;
}
#topnav-R {
	float: right;
	margin-right: 50px;
}
#dropdown{
	color:white;
	float:none;
	overflow: hidden;
	
}
.dropdown-content {
	
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 140px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 0;
}
.dropdown-content a{
	float: none;
	color: black;
	display: block;
	text-align: left;
	  padding: 12px 16px;
  text-decoration: none;
	font-size: 12px;
}
.dropdown-content a:hover {
  background-color: #ddd;
}
#dropdown .bt{
	
}
#dropdown:hover .dropdown-content {
  display: block;
}
#nav-drop:hover .dropdown-content {
  display: block;
}
#nav-drop{
	float:none;
}
</style>
</head>
<body>
<!-- ????????????????????? bar -->
	<div class="topnav">
		<div id = "topnav-L">
			<a href="#news" class="bt">?????? ???????????? ????????? ???????????????! > </a> 
		</div>
		<div id = "topnav-R">
			<a href="/member/login/loginform" class="bt">?????????</a>
			<a href="#contact" class="bt">????????????</a>
			<a href="#about" class="bt">??????Q&A</a>
			<div id="dropdown">
				<input type="button" class="btn" value="????????????">
					<i class="fa fa-caret-down"></i>
				
				<div class="dropdown-content">
					<a href="#">????????????</a>
					<a href="#">???????????? ??????</a>
					<a href="#">1:1 ??????</a>
					<a href="#">?????? ??????</a>
				</div>
			</div>
		</div>
	</div>
	<div class="mid">
			<a href = "#"><img src="../img/reallogo.png"
				width="150px" height="150px" /></a>
	</div>
<!-- ?????????????????? bar -->
	<div id="navbar">
		<div id="nav-drop">
			<button>?????? ????????????
				<i class="fa fa-caret-down"></i>
			</button> 
				<div class="dropdown-content">
					<a href="#">????????????1</a>
					<a href="#">????????????2</a>
					<a href="#">????????????3</a>
				</div>
			</div>
		<a href="javascript:void(0)">?????? ??????</a>
		<a href="javascript:void(0)">?????????</a> 
		<a href="javascript:void(0)">????????????</a>
		<a href="javascript:void(0)">????????????</a>
		<a href="javascript:void(0)">??????/?????????</a>
		<div>
			<input type="text" placeholder="??????" size="70" id="searchbar"
				style="padding: 15px; font-size: 13px;">
		</div>
	</div>

	

	<script>
		window.onscroll = function() {
			myFunction()
		};
		var navbar = document.getElementById("navbar");
		var sticky = navbar.offsetTop;
		function myFunction() {
			if (window.pageYOffset >= sticky) {
				navbar.classList.add("sticky")
			} else {
				navbar.classList.remove("sticky");
			}
		}
	</script>
</body>
</html>