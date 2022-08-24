<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.elex.Customer,java.util.HashMap" %>
    
    <%
    Customer customer = new Customer();
    customer.setName("홍길동");
    customer.setEmail("hong@naver.com");
    customer.setPhone("010-1234-1234");
    request.setAttribute("customer"	, customer);
    
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("name","소나나");
    map.put("maker", "현대자동차");
    request.setAttribute("car", map);
    
    %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<ul>
<li>이름 : ${ customer.name}</li>
<li>이메일 : ${customer.email}</li>
<li>전화번호 : ${customer.phone}</li>

</ul>

<%=customer.getName() %>

<br><br>

<ul>
<li>이름 : ${car.name}</li>
<li>메이커 : ${car.maker} </li>
</ul>

</body>
</html>