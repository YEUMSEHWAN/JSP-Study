<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String loginID = (String) session.getAttribute("loginID");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="style.css" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link href="https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap"
	rel="stylesheet" />
<title>Drink bar</title>
<script src="https://kit.fontawesome.com/7e4e126f96.js"	crossorigin="anonymous"></script>
<script src="main.js" defer></script>
</head>
<body>
	<nav class="navbar">
		<div class="navbar_logo">
			<i class="fa-solid fa-wine-bottle"></i> <a href="#">Name</a>
		</div>

		<ul class="navbar_bar">
			<li><a href="#">Main</a></li>
		</ul>
		<ul class="navbar_bar">
			<li><a href="#">주류목록</a>
		</ul>
		<ul class="navbar_bar">
			<li><a href="#">팀소개</a></li>
		</ul>

		<ul class="navbar_bar">
			<li><a href="#">커뮤니티</a>
				<ul class="drop-down">
					<li><a href="../community/qna.jsp">Q & A</a></li>
					<li><a href="../community/list.jsp">자유게시판</a></li>
				</ul>
			</li>
		</ul>
		<ul class="navbar_bar">
			<li><a href="#">마이페이지</a>
				<ul class="drop-down">
					<li><a href="../myPage/myPage.jsp">내정보</a></li>
					<li><a href="#">좋아요</a></li>
				</ul>
			</li>
		</ul>
		<ul class="navbar_icons">
			<li><a href="#"><i class="fa-regular fa-envelope"></i></a></li>
			<li><a href="login.jsp">Login/Join</a></li>
		</ul>
		<a href="#" class="navbar_toogleBtn"> <i class="fa-solid fa-bars"></i>
		</a>
	</nav>
</body>
</html>
