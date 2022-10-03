<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.login.UserVO"%>
<%@ page import="com.login.UserDAO"%>
<jsp:useBean id="dao" class="com.login.UserDAO"></jsp:useBean>


<!DOCTYPE html>
<html>
<title>로그인/회원가입 폼</title>
<script type="text/javascript" src="script.js"></script>
<link rel = "stylesheet" href = "../css/update.css">
<meta charset="UTF-8">
</head>
<script type="text">
function begin(){
document.myForm.userPassword.focus();
}
</script>
<%
String loginID = (String)session.getAttribute("loginID");
UserDAO usdao = new UserDAO();
UserVO vo = dao.getMember(loginID);
%>
<body onload = "begin()">
	<div class = "wrap">
	<div class = "form-wrap">
	<div class = "button-wrap">
	<div id = "btn"></div>
	<button type = "button" class = "togglebtn" onclick = "update()">Update</button>
	<button type = "button" class = "togglebtn" onclick = "delete1()">Delete</button>
	</div>
	<form id = "update" action="modifyProc.jsp" method = "post" class = "input-group2" name = "regForm">
		<%=loginID%>님 개인정보입니다.
		<input type = "password" class = "input-field" placeholder = "UserPassword" name = "userPassword" required>
		<input type = "password" class = "input-field" placeholder = "Password confirm" name = "user_Password" required>
		<input type = "email" class = "input-field" placeholder = "UserEmail" name = "userEmail" required>
		<input type = "text"  class = "input-field" placeholder = "UserName" name = "userName" required>
		<input type = "text" class = "input-field" placeholder = "select your type" name = "userAlchol" required>		
		<button class = "submit1" value = "정보수정">회원정보수정</button>
		<button class = "submit1" value = "취소" 
		onclick = "javascript:window.location = '../myPage/myPage.jsp'">취소</button>
	</form>
	
	<form id = "delete1" action="deleteProc.jsp" method = "post" class = "input-group1" onsubmit = "retrun checkid()">
		<%=loginID%>님 탈퇴하시겠습니까?
		<input type = "password" class = "input-field" placeholder = "UserPassword" name = "userPassword" required>
		정말로 회원 탈퇴 하시겠습니까?
		<button class = "submit" value = "회원탈퇴">회원 탈퇴</button>
		<button class = "submit" value = "취소" 
		onclick = "javascript:window.location = '../myPage/myPage.jsp'">취소</button>
	</form>

	</div>
	</div>
	<script>
	var x = document.getElementById("update");
	var y = document.getElementById("delete1");
	var z = document.getElementById("btn");
	
	
	function update(){
		x.style.left = "50px";
		y.style.left = "450px";
		z.style.left = "0";
	}
	function delete1() {
		x.style.left = "-400px";
		y.style.left = "50px";
		z.style.left = "110px";
	}
	
	</script>
</body>
</html>