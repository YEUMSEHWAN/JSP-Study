<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="com.login.UserDAO"></jsp:useBean>

<%
String loginID = request.getParameter("loginid");
boolean check = dao.idCheck(loginID);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 중복체크</title>
<script type="text/javascript" src="script.js"></script>
</head>
<body bgcolor = "#FFFFCC">
	<br>
	<div align="center">
		<b><%=loginID%></b>
		<%
		if (check) {
			out.println("는 이미 존재하는 ID입니다.");
		} else {
			out.println("사용 가능한 ID 입니다.");
		}
		%>
		<a href="#" onclick="jacascript:self.close()">닫기</a>
	</div>
</body>
</html>