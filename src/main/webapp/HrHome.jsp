<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
	button {
  		margin: 20px;
	}
	.custom-btn {
  		width: 130px;
  		height: 40px;
  		color: #fff;
  		border-radius: 5px;
  		margin: 10px 25px;
  		padding: 10px 25px;
  		font-family: 'Lato', sans-serif;
  		font-weight: 500;
  		background: transparent;
  		cursor: pointer;
  		transition: all 0.3s ease;
  		position: relative;
  		display: inline-block;
   		box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
   					7px 7px 20px 0px rgba(0,0,0,.1),
   					4px 4px 5px 0px rgba(0,0,0,.1);
  		outline: none;
	}

	.btn-2 {
  		background: rgb(96,9,240);
  		background: linear-gradient(0deg, rgba(96,9,240,1) 0%, rgba(129,5,240,1) 100%);
  		border: none;
  	}
	.btn-2:before {
  		height: 0%;
  		width: 2px;
	}
	.btn-2:hover {
  		box-shadow:  4px 4px 6px 0 rgba(255,255,255,.5),
              -4px -4px 6px 0 rgba(116, 125, 136, .5), 
    	inset -4px -4px 6px 0 rgba(255,255,255,.2),
    	inset 4px 4px 6px 0 rgba(0, 0, 0, .4);
	}
	.main
	{
		
		display: flex;
		align-items: center;
		flex-direction: column;
	}
	h1,a
	{
		text-align: center;
	}
</style>

</head>
<body>
	<h1>Welcome to HR HomePage !!</h1><br>
	1.<a href="AddUser.jsp" class = "main custom-btn btn-2">Add User</a><br>
	2.<a href="ListAllEmployeeController" class = "main custom-btn btn-2">List All User</a><br>
	3.<a href="SearchEmployee.jsp" class="main custom-btn btn-2">Search user</a>

</body>
</html>