<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.google.bean.HRBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		HRBean hr = (HRBean) request.getAttribute("hr");
	%>
	<h1>HR Details</h1><br><br>
	<p><b><u>Id</u>:</b><span>${hr.id}</span> </p>
	<p><b><u>Name</u>:</b><span>${hr.name}</span> </p>
	<p><b><u>Email</u>:</b><span>${hr.email}</span> </p>
	<p><b><u>Password</u>:</b><span>${hr.password}</span></p> 
</body>
</html>