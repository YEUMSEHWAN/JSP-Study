<%@page import="model.BoardDAO"%>
<%@page import="model.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/1fd422b08e.js" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@200&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@200;300&display=swap" rel="stylesheet">
<link rel="stylesheet" href="BoardDelete.css">
<title> </title>
</head>
<body>

<%
	BoardDAO bdao = new BoardDAO();
	
	int num = Integer.parseInt(request.getParameter("num"));
	//하나의 게시글을 리턴
	BoardBean bean = bdao.getOneUpdateBoard(num);
%>

<form action="BoardDeleteProc.jsp" method="post">
<main>
        <div class="deleteTitle">Want to delete your post?</div>
        <table width="520px">
            <tr>
                <td class="each_element">ID</td>
                <td class="el"><%=bean.getWriter() %></td>
            </tr>
            <tr>
                <td class="each_element">Date</td>
                <td class="el"><%=bean.getReg_date() %></td>
            </tr>
            <tr>
                <td class="each_element">Title</td>
                <td class="el"><%=bean.getSubject() %></td>
            </tr>
            <tr>
                <td class="each_element">Password</td>
                <td class="el"><input type="password" name="password"></td>
            </tr>
        </table>
        <div class="buttons">
        	<input type="hidden" name="num" value="<%=num %>">
            <input class="delete_button" type="submit" value="Delete">
            <input class="delete_button" type="button" value="Back to list" onclick="location.href='index.jsp?center=BoardList.jsp'">
    </div>	
    </main>
</form>


</body>
</html>