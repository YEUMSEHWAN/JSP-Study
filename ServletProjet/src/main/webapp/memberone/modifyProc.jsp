<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="com.memberone.*"%>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dao" class="com.memberone.StudentDAO" />
<jsp:useBean id="vo" class="com.memberone.StudentVO">
	<jsp:setProperty name="vo" property="*"/>
	</jsp:useBean>

<%
String loginID = (String) session.getAttribute("loginID");
vo.setId(loginID);
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
		<font size="5" face="궁서체"> 입력하신 내용으로<b>회원정보가 수정되었습니다.</b><br><br>
		 3초후에 Login Page로 이동됩니다.
		</font>
	</div>

</body>
</html>