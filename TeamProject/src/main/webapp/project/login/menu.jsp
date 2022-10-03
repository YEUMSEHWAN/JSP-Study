<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String loginID = (String) session.getAttribute("loginID");
%>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<nav class="navbar navbar-expand  navbar-dark bg-dark">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="mainPage.jsp">Home</a>
		</div>
		<div>
			<ul class="navbar-nav mr-auto">
				<c:choose>
					<c:when test="${empty loginID}">
						<li class="nav-item"><a class="nav-link" href="<c:url value="login.jsp"/>">로그인/회원가입 </a></li>
					</c:when>
					<c:otherwise>
						<li style="padding-top: 7px; color: white">[<%=loginID%>님]</li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/member/logoutMember.jsp"/>">로그아웃 </a></li>
						<li class="nav-item"><a class="nav-link" href='<c:url value="/member/updateMember.jsp"/>'>회원 수정</a>
					</c:otherwise>
				</c:choose>
				<li class="nav-item"><a class="nav-link" href="<c:url value="/products.jsp"/>">상품 목록</a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="/addProduct.jsp"/>">상품 등록</a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="/editProduct.jsp?edit=update"/>">상품 수정</a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="/editProduct.jsp?edit=delete"/>">상품 삭제</a></li>			
			</ul>
		</div>
	</div>
</nav>