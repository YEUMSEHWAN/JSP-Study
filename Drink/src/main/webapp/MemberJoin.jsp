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
<link rel="stylesheet" href="MemberJoin.css">
<title> </title>
</head>
<body>


	<form action="MemberJoinProc.jsp" method="post">
	<main>
        <div class="joinTitle">Be Our Member!</div>
        <table>
            <tr>
                <td class="singupForm" colspan="2">Signup Form</td>
            </tr>
            <tr>
                <td class="each_element">ID</td>
                <td class="el"><input type="text" name="id"></td>
            </tr>
            <tr>
                <td class="each_element">Password</td>
                <td class="el"><input type="password" name="pass1"
                    placeholder="Only English and numbers for the password"></td>
            </tr>
            <tr>
                <td class="each_element">Confirm Password</td>
                <td class="el"><input type="password" name="pass2"></td>
            </tr>
            <tr>
                <td class="each_element">Email Address</td>
                <td class="el"><input type="email" name="email"></td>
            </tr>
            <tr>
                <td class="each_element">Phone Number</td>
                <td class="el"><input type="tel" name="tel"></td>
            </tr>
            <tr>
                <td class="each_element">Age</td>
                <td class="el radioW">
                    <input type="radio" name="age" value="10">Under twenty 
                    <input type="radio" name="age" value="20">twenty 
                    <input type="radio" name="age" value="30">thirty&nbsp; &nbsp; 
                    <br />
                    <input type="radio" name="age" value="40">fourty 
                    <input type="radio" name="age" value="50">fifty 
                    <input type="radio" name="age" value="60">Over fifty &nbsp;
                </td>
            </tr>
            <tr>
                <td class="each_element">Comment</td>
                <td class="el"><textarea name="info"></textarea></td>
            </tr>
        </table>
        <div class="buttons">
            <input class="each_button" type="submit" value="Submit">
            <input class="each_button" type="reset" value="Reset">
        </div>
       
    </main>
	</form>


</body>
</html>