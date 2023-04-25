<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.bean.HRBean"%>
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
	<h1 align="center">HR Edit-Information form</h1><br><br>
	<form action="EditHRController" method="post" align="center" class="main"><br>
		<input type="hidden" name="id" value="${hr.id}">
		Name: <input type="text" name="name" placeholder="Enter your name" value="${hr.name}" ><br>
		Email: <input type="email" name="email" placeholder="Enter your email" value="${hr.email}"><br>
		Password: <input type="password" name="password" placeholder="Enter your password" value="${hr.password}"><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>