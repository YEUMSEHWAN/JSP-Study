<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%
 request.setCharacterEncoding("UTF-8");

String userID = request.getParameter("userID");
String userPassword = request.getParameter("userPassword");
String userEmail = request.getParameter("userEmail");
String userName = request.getParameter("userName");
String userJumin = request.getParameter("userJumin");
String userAlchol = request.getParameter("userAlchol");
%>
<sql:setDataSource var = "dataSource" url = "jdbc:mysql://localhost:3306/BBS"
driver = "com.mysql.jdbc.Driver" user = "root" password = "tiger"/>
<sql:update dataSource = "${dataSource }" var ="resultSet">
insert into user values(?,?,?,?,?,?)
	<sql:param value = "<%=userID %>"/>
	<sql:param value = "<%=userPassword %>"/>
	<sql:param value = "<%=userEmail %>"/>
	<sql:param value = "<%=userName %>"/>
	<sql:param value = "<%=userJumin %>"/>
	<sql:param value = "<%=userAlchol %>"/>
	</sql:update>
	<c:if test="${resultSet >=1 }">
	<c:redirect url = "resultMember.jsp?msg=1"/>
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