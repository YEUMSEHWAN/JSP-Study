<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.logon.LoginDBBean" %>
<% request.setCharacterEncoding("utf-8"); %>

<%

//String
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");

LoginDBBean manager = LoginDBBean.getInstance();

int check = manager.userCheck(id, passwd);

if (check == 1) {//로그인 성공
	Cookie cookie = new Cookie("memid",id);
	cookie.setMaxAge(2*60);
	response.addCookie(cookie);
	response.sendRedirect("cookieLoginConfirm.jsp");
	
	
} else if (check == 0) {//아이디는 존재하는데 비밀번호가 오류
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