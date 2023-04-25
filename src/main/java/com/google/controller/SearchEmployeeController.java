package com.google.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.bean.EmployeeBean;
import com.google.dao.UserDao;

@WebServlet("/SearchEmployeeController")
public class SearchEmployeeController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String language = req.getParameter("language");
		String technology = req.getParameter("technology");
		String database = req.getParameter("databases");
//		System.out.println("database: " + database);
		
		String[] lanarr = new String[0];
		if(language.trim().length()>0)
		{
			lanarr = language.split(",");
		}
		String[] techarr = new String[0];
		if(technology.trim().length()>0)
		{
			techarr = technology.split(",");
		}
		String[] dbarr=new String[0];
		if(database.trim().length()>0)
		{
			dbarr = database.split(",");
		}
		
		ArrayList<EmployeeBean> employees = new UserDao().SearchEmployee(name, lanarr, techarr, dbarr);
		
		req.setAttribute("employee", employees);
		req.getRequestDispatcher("SearchTable.jsp").forward(req, resp);
		
		
//		System.out.println(name + " " + language + " " + technology + " " + database);
//		super.doPost(req, resp);
	}
}
