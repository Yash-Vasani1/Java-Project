<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.btn-2 {
  width: 130px;
  height: 40px;
  color: #fff;
  border-radius: 5px;
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
		border: solid 5px red;
	}
	@import "bourbon";

body {
	background: #eee !important;	
}

.wrapper {	
	margin-top: 80px;
  margin-bottom: 80px;
}

.form-signin {
  max-width: 380px;
  padding: 15px 35px 45px;
  margin: 0 auto;
  background-color: #fff;
  border: 1px solid rgba(0,0,0,0.1);  

  .form-signin-heading,
	.checkbox {
	  margin-bottom: 30px;
	}

	.checkbox {
	  font-weight: normal;
	}

	.form-control {
	  position: relative;
	  font-size: 16px;
	  height: auto;
	  padding: 10px;
		@include box-sizing(border-box);

		&:focus {
		  z-index: 2;
		}
	}

	input[type="text"] {
	  margin-bottom: -1px;
	  border-bottom-left-radius: 0;
	  border-bottom-right-radius: 0;
	}

	input[type="password"] {
	  margin-bottom: 20px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
}

	span
	{
		color: red;
	}
</style>

</head>
<body>
	<%
		String nameerror = (String) request.getAttribute("nameerror");
		String emailerror = (String) request.getAttribute("emailerror");
		String passworderror = (String) request.getAttribute("passworderror");
	%>
	
	<div class = "wrapper">
	<form action="AddHRController" method="post" align="center" class="form-signin"><br>
	<h1 align="center" class="form-signin-heading">HR Registration form</h1><br><br>
		Name: &nbsp&nbsp<input type="text" name="name" placeholder="Enter your name" value="${user.name}" class="form-control" ><span><%=nameerror==null?"":nameerror %></span><br>
		Email: &nbsp&nbsp<input type="email" name="email" placeholder="Enter your email" value="${user.email}" class="form-control"><span><%=emailerror==null?"":emailerror %></span><br>
		Password: <input type="password" name="password" placeholder="Enter your password" class="form-control"><br>
		<input type="submit" value="Submit" class="btn-2 custom-btn">
	</form>
	</div>
	
</body>
</html>