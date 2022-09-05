<%@page import="com.mysql.cj.xdevapi.Table"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String loginID = (String) session.getAttribute("loginID");
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm</title>
</head>
<body>
<%
if(loginID != null){//로그인 되었을때 화면 출력
%>
<table width = "300" border = "1">
<tr>
<td colspan = "3" align = "center"> <%=loginID%>님 환영합니다.</td>
</tr>

<tr>
<td width = "100" align = "center">
<a href = "modifyForm.jsp">회원 정보 수정</a>
</td>

<td width = "100" align = "center">
<a href = "deleteForm.jsp">회원 탈퇴</a>
</td>

<td width = "100" align = "center">
<a href = "logout.jsp">로그 아웃</a>
</td>



</tr>
</table>

</body>
</html>