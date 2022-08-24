<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	request.setCharacterEncoding("utf-8");
    	
   		String name = request.getParameter("name");
   		String subject = request.getParameter("subject");
   		String filename1 = request.getParameter("filename1");
   		String filename2 = request.getParameter("filename2");
   		String origfilename1 = request.getParameter("origifilename1");
   		String origfilename2 = request.getParameter("origifilename2");

    %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 확인 및 다운로드</title>
</head>
<body>
	올린사람 :<%=name %> 
	제목 : <%=subject %>
	파일명1 : <a href = "C/webworkspace/.metadata/.plugins/org.eclipse.wst.server.core/.tmp0/.wtpwebapps/.ServletProjet<%=filename1%>"><%=origfilename1 %></a>
	파일명2 : <a href = "C/webworkspace/.metadata/.plugins/org.eclipse.wst.server.core/.tmp0/.wtpwebapps/.ServletProjet<%=filename2%>"><%=origfilename2 %></a>
</body>
</html>