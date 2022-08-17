<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true"  %>
    <% response.setStatus(HttpServletResponse.SC_OK); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외 발생</title>
</head>
<body>
고객님께서 요청하신 처리과정에서 예외가 발생하셨습니다.<br><br>
빠른 시간내에 문제를 신속히 처리하여 해결하도록 하겠습니다.<br>
보다 나은 서비스를 위해 항상 노력하겠습니다. 감사합니다.<br>
감사합니다!<br>
<br>
에러타입 :<%=exception.getClass().getName() %><br>
에머메시지 :  <%=exception.getMessage() %>



</body>
</html>