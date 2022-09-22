<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.login.*"%>
<jsp:useBean id="dao" class="com.login.UserDAO" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<%
String loginID = (String) session.getAttribute("loginID");
String loginPASS = request.getParameter("loginPASS");

int check = dao.deleteMember(loginID, loginPASS);
%>
<body>

</body>
</html>