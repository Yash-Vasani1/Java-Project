<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.main
	{
		
		display: flex;
		align-items: center;
		flex-direction: column;
		border: solid 5px red;
	}
	h1
	{
		text-align: center;
	}
	span
	{
		color: red;
	}
</style>
</head>
<body>

	<%
		String error = (String) request.getAttribute("Error");
	%>

	<h1>Admin Login Form</h1><br><br>
	<form action="AdminLoginController" method="post" class="main">
		Email/Name: <input type="text" name="emailname" placeholder="Enter Email or Name" value="Admin"><br>
		Password: <input type="password" name="password" placeholder="Enter your password" Value="Admin"><br>
		<input type="submit" value="Submit"><br>
		
		<span color = red><%=error==null?"":error %></span><br>
		
		
	</form>
</body>
</html>