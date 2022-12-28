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
<link rel="stylesheet" href="BoardInfo.css"> 
<title> </title>
</head>
<body>
<%
	int num = Integer.parseInt(request.getParameter("num").trim());//공백제거후 정수형으로 바뀜

	//데이터 베이스 접근
	BoardDAO bdao = new BoardDAO();
	//boardbean타입으로 하나의 게시글을 리턴
	BoardBean bean = bdao.getOneBoard(num);
%>
<main>
        <div class="informationTitle">The post <%=bean.getNum() %></div>
        <table width="600px">
            <tr>
                <td class="each_element">No.</td>
                <td class="el no_viewcount"><%=bean.getNum() %></td>
                <td class="each_element">View Count</td>
                <td class="el no_viewcount"><%=bean.getReadcount() %></td>
            </tr>
            <tr>
                <td class="each_element">ID</td>
                <td class="el"><%=bean.getWriter() %></td>
                <td class="each_element">Date</td>
                <td class="el"><%=bean.getReg_date() %></td>
            </tr>
            <tr>
                <td class="each_element">Email Address</td>
                <td class="el" colspan="3"><%=bean.getEmail() %></td>
            </tr>
            <tr>
                <td class="each_element">Title</td>
                <td class="el" colspan="3"><%=bean.getSubject() %>td>
            </tr>
            <tr>
                <td class="each_element">Content</td>
                <td class="el" colspan="3"><p class="el_content"> <%=bean.getContent() %></p></td>
            </tr>
        </table>
        <div class="buttons">
            <input class="each_button" type="button" value="Reply"
            onclick="location.href='index.jsp?center=BoardReWriteForm.jsp?num=<%=bean.getNum() %>&ref=<%=bean.getRef() %>&re_step=<%=bean.getRe_step() %>&re_level=<%=bean.getRe_level() %>'">
            <input class="each_button" type="button" value="Update" onclick="location.href='index.jsp?center=BoardUpdateForm.jsp?num=<%=bean.getNum() %>'">
            <input class="each_button" type="button" value="Delete" onclick="location.href='index.jsp?center=BoardDeleteForm.jsp?num=<%=bean.getNum() %>'">
            <input class="each_button" type="button" value="Back to list" onclick="location.href='index.jsp?center=BoardList.jsp'">
    </div>	
    </main>



</body>
</html>