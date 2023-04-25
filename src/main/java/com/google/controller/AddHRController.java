package com.google.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.bean.HRBean;
import com.google.dao.UserDao;

@WebServlet("/AddHRController")
public class AddHRController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(password);
		
		boolean isError = false;
		StringBuffer error = new StringBuffer("");
		HRBean hrbean = new HRBean();
		
		if(name=="" || name.trim().length()==0)
		{
			isError = true;
			req.setAttribute("nameerror", "Please Enter Name !!");
		}else if(name.trim().length()<2)
		{
			isError = true;
			req.setAttribute("nameerror", "Please enter atleaset 2 characters in name !!");
			hrbean.setName(name);
			
		}else
		{
			String alpha = "[a-zA-Z]+"; // minimum 1 char max n
			if(name.matches(alpha) == false)
			{
				isError = true;
				req.setAttribute("nameerror", "Please enter valid name !! ");
				hrbean.setName(name);
			}else
			{
				hrbean.setName(name);
			}
		}
		
		//email validation
		if(email=="" || email.trim().length()==0)
		{
			isError = true;
			req.setAttribute("emailerror", "Please  Enter EmailId !!");
//			ubean.setEmail(email);
		}
		else if(email.trim().length()<11)
		{
			isError = true;
			req.setAttribute("emailerror", "Please Enter atleast 11 characters in email!!");
			hrbean.setEmail(email);
		}
		else
		{
			String alpha = "[a-zA-Z]+[0-9]+@[g][m][a][i][l][.][c][o][m]";
			if(email.matches(alpha)==false)
			{
				isError = true;
				req.setAttribute("emailerror", "Please Enter Valid EmailId !!");
				hrbean.setEmail(email);
			}else
			{
				hrbean.setEmail(email);
			}
		}
		
		//password validation
		if(password=="" || password.trim().length()==0)
		{
			isError = true;
			req.setAttribute("passworderror", "Please Enter Password !!");
		}else if(password.trim().length()<8)
		{
			isError = true;
			req.setAttribute("passworderror", "Please enter atleast 8 chatacters !!");
		}else
		{
			String alpha = "[A-Z][a-z0-9]+";
			if(password.matches(alpha))
			{
				isError = true;
				req.setAttribute("passworderror", "Please Enterr Valid Password !!");
			}
			else
			{
				hrbean.setPassword(password);
			}
		}
		
		req.setAttribute("user", hrbean);
		
		if(isError)
		{
			System.out.println("Error occurs !!");
			req.getRequestDispatcher("AddHR.jsp").forward(req, resp);
		}
		else
		{
			UserDao udao = new UserDao();
			udao.addHR(hrbean);
			req.getRequestDispatcher("HrLogin.jsp").forward(req, resp);
		}
		
		
//		super.doPost(req, resp);
	}

}
