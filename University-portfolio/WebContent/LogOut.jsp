<%@page import="javax.websocket.SendResult"%>
<%@page import="org.apache.catalina.ha.backend.Sender"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	session.removeAttribute("vo");
    	request.removeAttribute("list");
    %>
	   
	<%
    	response.sendRedirect("/BIT_UNV/main.jsp");
    %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reset.css" type="text/css">
</head>
<body>

</body>
</html>