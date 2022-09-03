<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="dao" class="com.login.UserDAO" />

<%
	String email = request.getParameter("email");
	String pass = request.getParameter("pass");
	
	int check = dao.loginCheck(email, pass);
	
	if(check == 1){//로그인 성공시..
		session.setAttribute("email", email);
	response.sendRedirect("main.jsp");
	}



%>


<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

</body>
</html>