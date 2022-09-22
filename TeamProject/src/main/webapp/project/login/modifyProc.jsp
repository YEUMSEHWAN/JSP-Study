<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.login.*"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="dao" class="com.login.UserDAO" />
<jsp:useBean id="vo" class="com.login.UserVO">
	<jsp:setProperty name="vo" property="*" />
</jsp:useBean>

<%
String loginID = (String) session.getAttribute("loginID");
vo.setuserID(loginID);
dao.updateMember(vo);
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Refresh" content="3;url=login.jsp">
<title>회원 정보 수정 완료</title>
</head>
<body>
	<div align="center">
		<font size="5" face="궁서체"><b>회원정보가 수정되었습니다.</b><br> 3초후
			Login Page로 이동합니다. </font>
	</div>
</body>
</html>