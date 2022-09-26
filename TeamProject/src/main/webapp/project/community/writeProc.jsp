<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.board.BoardDAO" %>
<%@ page import="java.sql.Timestamp" %>
<% request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="article" class="com.board.BoardVO" scope="page"/>
	<jsp:setProperty name = "article" property="*" />
<%@ page import="com.login.UserVO"%>
<%@ page import="com.login.UserDAO"%>
<jsp:useBean id="dao" class="com.login.UserDAO" />
<jsp:useBean id="vo" class="com.login.UserVO"/>
<% 
String loginID = (String)session.getAttribute("loginID");
vo.setuserID(loginID);
dao.updateMember(vo);
%>

<%
article.setRegdate(new Timestamp(System.currentTimeMillis()));

BoardDAO dbPro = BoardDAO.getInstance();
dbPro.insertArticle(article);

response.sendRedirect("list.jsp");

%>