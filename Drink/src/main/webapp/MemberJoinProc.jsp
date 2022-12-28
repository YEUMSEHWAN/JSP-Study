<%@page import="model.MemberDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
</head>
<body>


<%
	request.setCharacterEncoding("UTF-8");


%>
	<!-- useBean을 이용하여 한꺼번에 데이터를 받아옴 -->
	<jsp:useBean id="mbean" class="model.MemberBean">
		<jsp:setProperty name="mbean" property="*"/><!-- 맵핑 시키시오 -->
	</jsp:useBean>
	
<%
	
	
	//데이터 베이스 클래스 객체 생성
	MemberDAO mdao = new MemberDAO();
	mdao.insertMember(mbean);
	
	//회원 가입이 되었다면 회원 정보를 보여주는 페이지로 이동시킴
	response.sendRedirect("index.jsp?center=MemberLogin.jsp");

%>


</body>
</html>