<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%
String loginID = (String) session.getAttribute("loginID");
%>

<%
	request.setCharacterEncoding("UTF-8");

	String userID = request.getParameter("userID");
	String userPassword = request.getParameter("userPassword");
	String userName = request.getParameter("userName");
	String userEmail = request.getParameter("userEmail");
	String userAlchol = request.getParameter("userAlchol");
%>

<sql:setDataSource var="BBS"
	url="jdbc:mysql://localhost:3306/BBS"
	driver="com.mysql.jdbc.Driver" user="root" password="tiger" />

<sql:update dataSource="${BBS}" var="resultSet">
   UPDATE user SET userPassword=?, userName=?, userEmail=?, userAlchol=? WHERE userID=?
   
	<sql:param value="<%=userPassword%>" />
	<sql:param value="<%=userName%>" />
	<sql:param value="<%=userEmail%>" />
	<sql:param value="<%=userAlchol%>" />	
	<sql:param value="<%=userID%>" />
</sql:update>

<c:if test="${resultSet>=1}">
	<c:redirect url="resultMember.jsp?msg=0" />
</c:if>

    
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title></title>

</head>
<body>

</body>
</html>