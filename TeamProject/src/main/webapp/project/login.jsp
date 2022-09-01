<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    
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
	<button type = "button" class = "togglebtn" onclick = "login()">로그인</button>
	<button type = "button" class = "togglebtn" onclick = "register()">회원가입</button>
	</div>
	<form id = "login" action="" class = "input-group">
		<input type = "text" class = "input-field" placeholder = "아이디 또는 이메일" required>
		<input type = "password" class = "input-field" placeholder = "비밀번호" required>
		<input type = "checkbox" class = "checkbox"><span>Remember Password</span>
		<button class = "submit" value = "로그인" onclick = "javascript:window.location='mainPage.jsp'">로그인</button>
	</form>
	
	<form id = "register" action="" class = "input-group">
		<input type = "text" class = "input-field" placeholder = "ID" required>
		<input type = "text" class = "input-field" placeholder = "NickNAme" required>
		<input type = "email" class = "input-field" placeholder = "Email" required>
		<input type = "password" class = "input-field" placeholder = "Password" required>
		<input type = "checkbox" class = "checkbox"><span>Terms and conditions</span>
		<button class = "submit" value = "회원가입" onclick = "javascript:window.location='mainPage.jsp'">회원가입</button>
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