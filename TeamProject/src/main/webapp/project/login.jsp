<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String loginID = (String)session.getAttribute("loginID");

%>
    
    
<!DOCTYPE html>
<html>
<title>로그인/회원가입 폼</title>
<link rel = "stylesheet" href = "css/login.css">
<meta charset="UTF-8">
</head>
<body>
	<div class = "wrap">
	<div class = "form-wrap">
	<div class = "button-wrap">
	<div id = "btn"></div>
	<button type = "button" class = "togglebtn" onclick = "login()">Login</button>
	<button type = "button" class = "togglebtn" onclick = "register()">Create ID</button>
	</div>
	<form id = "login" action="" class = "input-group1">
		<input type = "text" class = "input-field" placeholder = "UserID" required>
		<input type = "password" class = "input-field" placeholder = "UserPassword" required>
		<input type = "checkbox" class = "checkbox"><span>Remember Password</span><!-- java 코드로 10분간 동작이 없다면 자동 로그아웃 만들기! -->
		<button class = "submit" value = "로그인" onclick = "javascript:window.location='mainPage.jsp'">Login</button>
	</form>
	
	<form id = "register" action="" class = "input-group2">
		<input type = "UserName" class = "input-field" placeholder = "Name" required>
		<input type = "UserID" class = "input-field" placeholder = "ID" required>
		<input type = "UserEmail" class = "input-field" placeholder = "Email" required>
		<input type = "UserPassword" class = "input-field" placeholder = "Password" required>
		<input type = "UserJumin" class = "input-field" placeholder = "Jumin" required>
		<input type = "UserAlchol" class = "input-field" placeholder = "select your type" required>
		<input type = "checkbox" class = "checkbox"><span>Terms and conditions</span>
		<button class = "submit" value = "회원가입" onclick = "javascript:window.location='regForm.jsp'">Create</button>
	</form>
	</div>
	</div>
	<script>
	var x = document.getElementById("login");
	var y = document.getElementById("register");
	var z = document.getElementById("btn");
	
	
	function login(){
		x.style.left = "50px";
		y.style.left = "450px";
		z.style.left = "0";
	}
	
	function register() {
		x.style.left = "-400px";
		y.style.left = "50px";
		z.style.left = "110px";
	}
	</script>
</body>
</html>