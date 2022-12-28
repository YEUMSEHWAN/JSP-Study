<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.bbs.BoardDAO" %>
<%@ page import = "com.bbs.BoardVO" %>
<%@ page import = "java.io.PrintWriter" %>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="board" class = "com.bbs.BoardVO"/>
<jsp:setProperty property="subject" name="board"/>
<jsp:setProperty property="content" name="board"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%
	String userID = null;
	if(session.getAttribute("userID") != null){
		userID = (String) session.getAttribute("userID");
	}
	if(userID == null){
		PrintWriter script = response.getWriter();
		script.print("<script>");
		script.print("alert('로그인을 하세요.')");
		script.print("location.href = '../login/login.jsp'");
		script.print("<script>");
	}else{
		if(board.getSubject() == null || board.getContent() == null){
			PrintWriter script = response.getWriter();
			script.print("<script>");
			script.print("alert('입력이 안된 사항이 있습니다..')");
			script.print("history.back()");
			script.print("<script>");
		}else{
			BoardDAO boardDAO = new BoardDAO();
			int result = boardDAO.write(board.getSubject(), userID, board.getContent());
			if(result == -1){
				PrintWriter script = response.getWriter();
				script.print("<script>");
				script.print("alert('글쓰기에 실패했습니다..')");
				script.print("history.back()");
				script.print("<script>");
			}
			else{
				PrintWriter script = response.getWriter();
				script.print("<script>");
				script.print("location.href = 'bbs.jsp'");
				script.print("<script>");
			}
		}
	}
%>
</body>
</html>