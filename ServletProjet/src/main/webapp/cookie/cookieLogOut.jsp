<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
Cookie[] cookies = request.getCookies();

if (cookies != null) {

	for (int i = 0; i < cookies.length; i++) {
		if (cookies[i].getName().equals("memid")) {
	cookies[i].setMaxAge(0);
	response.addCookie(cookies[i]);
		}
	}

}
%>
<script type="text/javascript">
	alert("๋ก๊ทธ์์");
	loaction.href - "cookieMemberLogin.jsp";
</script>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

</body>
</html>