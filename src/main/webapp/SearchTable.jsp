<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@ page import="com.google.bean.EmployeeBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<EmployeeBean> emp = (ArrayList<EmployeeBean>) request.getAttribute("employee");
	%>
	
	<h1>hello bro!! Here is your Result</h1>
	
	<table border=1>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Number</th>
			<th>Exprience</th>
			<th>ResumeURL</th>
		</tr>
		<%
			for(int i=0;i<emp.size();i++)
			{
		%>
		<tr>
			<th><%=emp.get(i).getId() %></th>
			<th><%=emp.get(i).getName() %></th>
			<th><%=emp.get(i).getEmail() %></th>
			<th><%=emp.get(i).getNumber() %></th>
			<th><%=emp.get(i).getExperience() %></th>
			<th><%=emp.get(i).getResumeurl() %></th>
		</tr>
		<%
			}
		%>
	</table>
	
</body>
</html>