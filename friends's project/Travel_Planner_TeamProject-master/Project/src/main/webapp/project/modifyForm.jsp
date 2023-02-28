<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행 스케쥴링 플래너 - 도죠</title>
<link rel="stylesheet" type="text/css" href="css/memberstyle.css">
<script type="text/javascript" src = "js/memberscript.js"></script>
</head>

<body>
<div class="center">
  <div class ="container">
	<div class ="text">회원 수정</div>
	<div class ="small-text">여행 스케쥴링 플래너 - 도죠</div>
	
	<form action="cityPlan.do?cmd=modifyProc" method = "post" name = "regForm"><!--회원가입 폼 안에 있는 정보들을 DB로 넣어줘야 된다. -->
	 	<div class="modify_div"><!--버튼을 눌러서 중복확인 중복화인은 자바스크립트로 함수로 구현  -->
	 	  <label class = "label-text">아이디</label>
	 	  <input class = "input-css" type = "text" name ="id" value="${id}" disabled>
		
	 	</div>
	 	
		<div class="modify_div">
	 	  <label class = "label-text">PASSWORD</label>
	 	  <input class = "input-css" type = "password" name ="pass" value="${pass}">
	 	</div>
	 	
	 	<div class="modify_div">
	 	  <label class = "label-text">PASSWORD확인</label>
	 	  <input class = "input-css" type = "password" name ="repass" value="${pass}">
	 	</div>
	 	
	 	<div class="modify_div">
	 	  <label class = "label-text">NickName</label>
	 	  <input class = "input-css" type = "text" name ="nick" value = "${nick }" disabled>
	 	  <!-- <input class = "#" type = "button">  닉네임을 다시 바꿀수 있게할지 고민중-->
	 	</div>
	 	
	 	<div class="modify_div">
	 	  <label class = "label-text">E-Mail</label>
	 	  <input class = "input-css" type = "text" name ="email" value = "${email }">
	 	</div>
	 
		<div class = "membership-withdrawal">
		 	<a class ="delete-link"href ="cityPlan.do?cmd=deleteForm">회원탈퇴</a>
		</div>
		
		<div>
			<input type ="button" class = "membergaip"  value = "회원수정" onclick="updateCheck()"><!--스크립트로 유효성 검사-->
		</div>
		<div>
			<input type ="button" class = "back-button" value = "뒤로가기" onclick="backbutton()"> 
		</div>
	
	</form>
  </div>
</div>		
	
</body>
</html>