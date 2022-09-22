<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String loginID = (String) session.getAttribute("loginID");
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
<a href = "../login/modifyForm.jsp">회원 정보 수정</a>
</td>

<td width = "100" align = "center">
<a href = "../login/deleteForm.jsp">회원 탈퇴</a>
</td>

<td width = "100" align = "center">
<a href = "../login/logout.jsp">로그 아웃</a>
</td>

</body>
</html>