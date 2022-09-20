<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.login.UserDAO"%>
<%@page import="java.io.PrintWriter"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<!-- 자바 빈 -->
<jsp:useBean id="user" class="com.login.UserVO" scope="page" />

<jsp:setProperty property="userID" name="user" />
<jsp:setProperty property="userPassword" name="user" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="../css/login.css">
<meta charset="UTF-8">
</head>

<body>
	<%
	UserDAO userDAO = new UserDAO();
	int result = userDAO.login(user.getuserID(), user.getuserPassword());
	if (result == 1) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("location.href = 'mainPage.jsp'");
		script.println("</script>");
	} else if (result == 0) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('비밀번호가 틀립니다.')");
		script.println("history.back()");
		script.println("</script>");
	} else if (result == -1) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('존재하지 않는 아이디 입니다..')");
		script.println("history.back()");
		script.println("</script>");
	}
	%>



</body>
</html>