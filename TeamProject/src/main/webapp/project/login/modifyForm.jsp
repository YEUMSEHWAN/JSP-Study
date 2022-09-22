<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.login.UserVO"%>
<%@ page import="com.login.UserDAO"%>
<jsp:useBean id="dao" class="com.login.UserDAO"></jsp:useBean>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<script type="text/javascript" src="script.js"></script>
</head>
<%
String loginID = (String) session.getAttribute("loginID");
UserVO vo = dao.getMember(loginID);
%>


<body>
	<form name="regForm" method="post" action="modifyProc.jsp">
		<table border="1">
			<tr>
				<td colspan="2" align="center">회원 정보 수정</td>
			</tr>

			<tr>
				<td align="center">아이디</td>
				<td><%=vo.getuserID()%></td>
			</tr>

			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="userPassword"
					value="<%=vo.getuserPassword()%>"></td>
			</tr>
			<tr>
				<td align="center">비밀번호 확인</td>
				<td><input type="password" name="repass"
					value="<%=vo.getuserPassword()%>"></td>
			</tr>
			<tr>
				<td align="center">이메일</td>
				<td><input type="userEmail" name="userEmail"
					value="<%=vo.getuserEmail()%>"></td>
			</tr>

			<tr>
				<td align="center">이름</td>
				<td><input type="userName" name="userName"
					value="<%=vo.getuserName()%>"></td>
			</tr>
			<tr>
				<td align="center">Alchol 선호도</td>
				<td><input type="userAlchol" name="userAlchol"
					value="<%=vo.getuserAlchol()%>"></td>

			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="수정" onclick="updateCheck()">
				<input type="button" value="취소" onclick="javascript:window.location = '../myPage/myPage.jsp'"></td>
			</tr>
		</table>
	</form>
</body>
</html>