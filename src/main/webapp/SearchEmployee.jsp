<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Search Employee</h1>
	<form action="SearchEmployeeController" method="post" align="center">
	<div>
		Name: <input type="text" name="name" placeholder="Enter name pattern to search">
	</div>
	<div>
		Language: <input type="text" name="language" placeholder="C, C++, JAVA, ...">
	</div>
	<div>
		Technology: <input type="text" name="technology" placeholder="JSP, SERVLET, SPRING, ...">
	</div>
	<div>
		Database: <input type="text" name="databases" placeholder="MSSQL, MYSQL, MONGODB, ...">
	</div>
		<input type="submit" value="SUBMIT">
	</form>
</body>
</html>