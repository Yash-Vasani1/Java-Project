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
		ArrayList<String> language = (ArrayList<String>) request.getAttribute("languages");
		ArrayList<String> technologies = (ArrayList<String>) request.getAttribute("technologies");
		ArrayList<String> databases = (ArrayList<String>) request.getAttribute("databases");
	%>
	
	<h1>hello bro!!</h1>
	
	<table border=1>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Number</th>
			<th>Exprience</th>
			<th>ResumeURL</th>
			<th>Languages</th>
			<th>Technologies</th>
			<th>Databases</th>
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
			<th><%=language.get(i) %></th>
			<th><%=technologies.get(i) %></th>
			<th><%=databases.get(i) %></th>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>