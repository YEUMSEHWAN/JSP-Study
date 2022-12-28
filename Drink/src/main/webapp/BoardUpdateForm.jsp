<%@page import="model.BoardBean"%>
<%@page import="model.BoardDAO"%>
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
<link rel="stylesheet" href="BoardUpdate.css">
<title> </title>
</head>
<body>


<%
	//해당 게시글번호를 통하여 게시글을 수정
	int num = Integer.parseInt(request.getParameter("num").trim());

	//하나의 게시글의 대한 정보를 리턴
	BoardDAO bdao = new BoardDAO();
	BoardBean bean = bdao.getOneUpdateBoard(num);
%>
<form action="BoardUpdateProc.jsp" method="post">
<main>
        <div class="rewriteTitle">Want to update your post?</div>
        <table width="700px">
            <tr>
                <td class="each_element">ID</td>
                <td class="el"> <%=bean.getWriter() %></td>
                <td class="each_element">Date</td>
                <td class="el"><%=bean.getReg_date() %></td>
            </tr>
            <tr>
                <td class="each_element">Title</td>
                <td colspan="3"><input class="el" type="text" name="subject" size="60" value="<%=bean.getSubject() %>"></td>
            </tr>
            <tr>
                <td class="each_element">Password</td>
                <td colspan="3"><input class="el" type="password" name="password" size="60"></td>
            </tr>
            <tr>
                <td class="each_element">Content</td>
                <td colspan="3"><textarea rows="10" cols="60" name="content" align="Left"><%=bean.getContent() %></textarea></td>
            </tr>
        </table>
        <div class="buttons">
        	<input type="hidden" name="num" value="<%=bean.getNum() %>">
            <input class="update_button" type="submit" value="Update">
            <input class="update_button" type="button" value="Back to list" onclick="location.href='index.jsp?center=BoardList.jsp'"></td>
        </div>
    </main>
</form>


</body>
</html>