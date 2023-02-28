<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <div class="container">
	<div class="text">SIGN UP</div>
	<div class="small-text">여행 스케쥴링 플래너 - 도죠</div>
	
	<form action="cityPlan.do?cmd=regProc" method="post" name="regForm"><!--회원가입 폼 안에 있는 정보들을 DB로 넣어줘야 된다. -->
	 <div class="regdiv" id="f_reg">  
	 	  <label class="label-text_reg">아이디</label>
	 	<div class = "form-container"><!--버튼을 눌러서 중복확인 중복화인은 자바스크립트로 함수로 구현  -->
	 	  <input class="input-css" type="text" name="id" >
	 	  <input class="input-button" type="button" value="아이디 확인" onclick="idCheck(this.form.id.value)"> <!--아이디 확인 버튼-->
	 	</div>
	 </div>
	 	
	 <div class="regdiv">
	 	  <label class="label-text_reg">PASSWORD</label>
		<div>
	 	  <input class="input-css" type="password" name="pass">
	 	</div>
	</div>
	
	 <div class="regdiv">
	 	  <label class="label-text_reg">PASSWORD확인</label>
	 	<div>
	 	  <input class="input-css" type="password" name="repass">
	 	</div>
	 </div>	
	 
	  <div class="regdiv">
	 	  <label class="label-text_reg">NickName</label>
	 	<div>
	 	  <input class="input-css" type="text" name="nick">
	 	  <input class="input-button" type="button" value="닉네임 확인" onclick="nickCheck(this.form.nick.value)">
	 	</div>
	 </div>
	 
	 <div class="regdiv">	
	 	  <label class="label-text_reg">E-Mail</label>
	 	<div>
	 	  <input class="input-css" type="text" name="email">
	 	</div>
	</div>
	 
		<div>
			<input type="button" class="membergaip"  value="회원가입" onclick="inputCheck()"><!--스크립트로 유효성 검사-->
		</div>
		
		<div>
			<input type="button" class="back-button" value="뒤로가기" onclick="backbutton()"> 
		</div>
	</form>
  </div>
</div>		
</body>
</html>