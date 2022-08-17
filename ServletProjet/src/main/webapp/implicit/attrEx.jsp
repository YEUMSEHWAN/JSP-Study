<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //pageContext Scope에 속성 값 저장하기(해당 jsp페이지 내에서만 유효)
    pageContext.setAttribute("pageAttribute", "홍길동");
    
    //pageContext.setAttribute("pageAttribute", "홍길동",pageContext.PAGE_SCOPE);
    
    //request Scope에 속성 저장하기(client request 객체가 유지되는 동안만 유효성을 가짐).
    request.setAttribute("requestAttribute", "010-1234-1235");
    pageContext.setAttribute("pageAttribute", "010-1234-1235",pageContext.REQUEST_SCOPE);
    
    //session Scope 속성 저장하기
    session.setAttribute("sessionAttribute", "hong@naver.com");
    pageContext.setAttribute("pageAttribute", "hong@naver.com",pageContext.SESSION_SCOPE);
    
    //application Scope 속성 저장하기
    application.setAttribute("applicationAttribute", "Global in(주)");
    pageContext.setAttribute("pageAttribute", "Global in(주)",pageContext.APPLICATION_SCOPE);
    
    %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<ul>
<li>이름 : <%=pageContext.getAttribute("pageAttribute") %></li>
<li>번호 : <%=request.getAttribute("requestAttribute") %></li>
<li>메일 : <%=session.getAttribute("sessionAttribute") %></li>
<li>회사 : <%=application.getAttribute("applicationAttribute") %></li>
</ul>

<%-- <jsp:useBean id="빈 이름" scope = "유효범위" class = "빈의 저장위치"|>
id : 객체를 식별하는 이름(인스턴스)
scope : 객체의 참조 유효범위를 의미함(기본 범위 : page)
class : 완전한 형태의 클래스 이름 
</jsp:useBean> --%>

</body>
</html>