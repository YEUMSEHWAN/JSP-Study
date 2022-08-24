<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="elfunc" uri="/WEB-INF/tlds/el-functions.tld"%>

<%
Date today = new Date();
request.setAttribute("today", today);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	오늘은
	<b>${elfunc:dateFormat(today)}</b>입니다.
</body>
</html>