<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="dao" class="com.login.UserDAO" />

<%
String userID = request.getParameter("userID");
String userPassword = request.getParameter("userPass");

int check = dao.loginCheck(userID, userPassword);

if (check == 1) {//로그인 성공
	session.setAttribute("loginID", userID);
	response.sendRedirect("../mainPage.jsp");
} else if (check == 0) {//아이디존재, 비밀번호 오류
%>
<script type="text/javascript">
	alert("비밀번호가 틀렸습니다.");
	history.go(-1);
</script>
<%
} else {
%>
<script type="text/javascript">
	alert("아이디가 존재하지 않습니다.");
	history.go(-1);
</script>
<%
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

</body>
</html>