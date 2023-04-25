package com.google.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.dao.UserDao;

@WebServlet("/CreateTableController")
public class CreateTableController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int flag = new UserDao().CreateADMINTable();
		
		if(flag==0)
		{
			req.getRequestDispatcher("Created.jsp").forward(req, resp);			
		}
		else
		{
			req.getRequestDispatcher("SussfullyCreated.jsp").forward(req, resp);
		}
//		super.doGet(req, resp);
	}

}
