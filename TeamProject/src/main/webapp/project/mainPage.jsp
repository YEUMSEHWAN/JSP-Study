<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
<div class = "wrap">
<form action="login.jsp" method = "post">
	<button class = "submit" value = "로그인 및 회원가입" onclick = "inputCheck()">login/create</button>
	</form>
	
	<form action="./myPage/myPage.jsp">
	<button class = "submit" value = "마이페이지" onclick = "javascript:window.location = './myPage/myPage.jsp'">myPage</button>
	</form>
	
	<form action="./community/list.jsp">
	<button class = "submit" value = "community" onclick = "javascript:window.location = './community/list.jsp'">community</button>
	</form>
</div>
</body>
</html>