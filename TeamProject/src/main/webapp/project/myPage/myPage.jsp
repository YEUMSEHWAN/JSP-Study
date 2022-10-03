<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.io.*" %>
    
<%
String loginID = (String) session.getAttribute("loginID");
%>
<%
if(loginID == null){
	PrintWriter sc = response.getWriter();
	sc.println("<script>");
	sc.println("alter('로그인 후 이용해 주세요.')");
	sc.println("history.back(-1)");
	sc.println("</script>");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<table width = "300" border = "1">
<tr>
<td colspan = "3" align = "center"><%= loginID%>님 환영합니다.</td>
</tr>

<tr>
<td width = "100" align = "center">
<a href = "../login/updateMember.jsp">회원수정 및 탈퇴</a>
</td>

<td width = "100" align = "center">
<a href = "../login/logout.jsp">로그 아웃</a>
</td>
</body>
</html>