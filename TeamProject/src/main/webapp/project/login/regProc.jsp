<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.login.UserDAO"%>
<%@page import="com.login.UserVO"%>
<%@page import="java.io.PrintWriter"%>
<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="vo" class="com.login.UserVO" />
<jsp:useBean id="dao" class="com.login.UserDAO" />
<jsp:setProperty property="userID" name="vo" />
<jsp:setProperty property="userPassword" name="vo" />
<jsp:setProperty property="userEmail" name="vo" />
<jsp:setProperty property="userName" name="vo" />
<jsp:setProperty property="userJumin" name="vo" />
<jsp:setProperty property="userAlchol" name="vo" />

<%
boolean flag = dao.memberInsert(vo);
%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<meta charset="UTF-8">
<title>회원가입 확인</title>
<link rel="stylesheet" href="css/login.css">

</head>
<body>
	<%
	UserDAO userDAO = new UserDAO();
	boolean memberInsert = userDAO.memberInsert(vo);
	if (flag) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('회원가입에 성공하셨습니다.')");
		script.println("alert('로그인후 이용해주세요!.')");
		script.println("location.href ='login.jsp'");
		script.println("</script>");
	} else {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 존재하는 아이디 입니다.')");
		script.println("history.back()");
		script.println("</script>");
	}
	%>
	
</body>
</html>