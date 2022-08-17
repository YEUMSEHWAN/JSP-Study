<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="join" class="com.join.JoinBean"></jsp:useBean>
<jsp:setProperty property="*" name="join" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 입력 정보 확인</title>
<style type="text/css">
table {
	width: 400px;
}

h1 {
	text-align: center;
}
</style>



</head>
<body>
	<h1>회원가입 입력 정보 확인</h1>


	<tabel>
	<tr>
		<td><b>아이디 : </b></td>
		<td><jsp:getProperty property="id" name="join" /></td>
	</tr>

	<br>
	<tr>
		<td><b>비밀번호 : </b></td>
		<td><jsp:getProperty property="pass" name="join" /></td>
	</tr>

	<br>
	<tr>
		<td><b>이름 : </b></td>
		<td><jsp:getProperty property="name" name="join" /></td>
	</tr>
	<br>
	<tr>
		<td><b>성별 : </b></td>
		<td><jsp:getProperty property="gender" name="join" />
	</tr>

	<br>
	<tr>
		<td><b>나이 : </b></td>
		<td><jsp:getProperty property="age" name="join" /></td>
	</tr>

	<br>
	<tr>
		<td><b>이메일 : </b></td>
		<td><jsp:getProperty property="email" name="join" /></td>
	</tr>




	</tabel>

</body>
</html>