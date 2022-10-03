<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%
	request.setCharacterEncoding("UTF-8");

	String userID = request.getParameter("id");
	String userPassword = request.getParameter("password");
%>

<sql:setDataSource var="BBS"
	url="jdbc:mysql://localhost:3306/BBS"
	driver="com.mysql.jdbc.Driver" user="root" password="tiger" />

<sql:query dataSource="${BBS}" var="resultSet">
   SELECT * FROM user WHERE userID=? and userPassword=?  
   <sql:param value="<%=userID%>" />
	<sql:param value="<%=userPassword%>" />
</sql:query>

<c:forEach var="row" items="${resultSet.rows}">
	<%
		session.setAttribute("sessionId", userID);
	%>
	<c:redirect url="resultMember.jsp?msg=2" />
</c:forEach>

<c:redirect url="loginMember.jsp?error=1" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

</body>
</html>