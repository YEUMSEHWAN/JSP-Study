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
<link rel="stylesheet" href="BoardWrite.css">
<title> </title>
</head>
<body>


<%
	int num = Integer.parseInt(request.getParameter("num"));
	int ref = Integer.parseInt(request.getParameter("ref"));
	int re_step = Integer.parseInt(request.getParameter("re_step"));
	int re_level = Integer.parseInt(request.getParameter("re_level"));
%>

<form action="BoardReWriteProc.jsp" method="post">
<main>
        <div class="writeTitle">Fill out this form</div>
        <table>
           <tr>
             <td class="each_element">ID</td>
             <td class="el"><input type="text" name="writer"></td>
           </tr>
           <tr>
            <td class="each_element">Title</td>
            <td class="el"><input type="text" name="subject" value="↳re:"></td>
          </tr>
          <tr>
            <td class="each_element">Email Address</td>
            <td class="el"><input type="email" name="email"></td>
          </tr>
          <tr>
            <td class="each_element">Password</td>
            <td class="el"><input type="password" name="password"></td>
          </tr>
          <tr>
            <td class="each_element">Content</td>
            <td class="el"><textarea rows="10" cols="60" name="content"></textarea></td>
          </tr>
        </table>
        <p class="announce">*It might take approximately 3 days to respond.</p>
        <div class="buttons">
        	<input type="hidden" name="ref" value="<%=ref %>">
			<input type="hidden" name="re_step" value="<%=re_step %>">
			<input type="hidden" name="re_level" value="<%=re_level %>">
            <input class="each_button" type="submit" value="Upload">
            <input class="each_button" type="reset" value="Reset">
            <input class="each_button" type="button" value="Back to list" onclick="location.href='index.jsp?center=BoardList.jsp'">
        </div>	
    </main>
</form>


</body>
</html>