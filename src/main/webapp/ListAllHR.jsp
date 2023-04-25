<%@page import="com.google.bean.HRBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<HRBean> hrs = (ArrayList<HRBean>) request.getAttribute("AllHR");
	%>
	<h1>List of HR</h1><br><br>
	
	<table border=1>
	
		<tr>
			<th>HR_ID</th>
			<th>HR_Name</th>
			<th>HR_Email</th>
			<th>HR_Password</th>
			<th colspan=3>Action</th>
		</tr>
		<%
			for(HRBean hr : hrs)
			{
		%>
		<tr>
			<td><%= hr.getId() %></td>
			<td><%= hr.getName() %></td>
			<td><%= hr.getEmail() %></td>
			<td><%= hr.getPassword() %></td>
			<td><a href="DeleteHRController?id=<%=hr.getId()%>">Delete</a></td>
			<td><a href="ViewHRController?id=<%=hr.getId()%>">View</a></td>
			<td><a href="EditHRController?id=<%=hr.getId()%>">Edit</a></td>
		</tr>
		<%
			}
		%>
	</table>
	
	
</body>
</html>