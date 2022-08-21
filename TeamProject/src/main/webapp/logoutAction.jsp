<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<%
		//로그아웃시 session을 빼어와서 여기로 오는것.
		session.invalidate();
	
	%>
	
	<script>
		location.href = 'main.jsp';
	</script>
</body>
</html>