package com.google.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
//import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.dao.UserDao;

@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = req.getParameter("emailname");
		String password = req.getParameter("password");
		
		System.out.println(uname);
		System.out.println(password);
		
		int flag = new UserDao().AdminLogin(uname, password);
		RequestDispatcher rd =  null;
//		System.out.println(flag);
		if(flag==0)
		{
			System.out.println("Not Valid ID or Password !!");
			req.setAttribute("Error", "Invalid UserName or Password !!");
			req.getRequestDispatcher("AdminLogin.jsp").forward(req, resp);
			
		}
		else
		{
			System.out.println("Valid !!");
			req.getRequestDispatcher("AdminHome.jsp").forward(req, resp);
		}
		
//		super.doPost(req, resp);
	}
	
}
