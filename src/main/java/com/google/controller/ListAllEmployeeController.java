package com.google.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.bean.EmployeeBean;
import com.google.bean.HRBean;
import com.google.dao.UserDao;

@WebServlet("/ListAllEmployeeController")
public class ListAllEmployeeController extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<EmployeeBean> emp = new UserDao().getAllEmployee();
		ArrayList<String> languages = new ArrayList<String>();
		ArrayList<String> technologies = new ArrayList<String>();
		ArrayList<String> databases = new ArrayList<String>();
		System.out.println("I am in List All Employrr Controller !! \n");
		for(int i=0;i<emp.size();i++)
		{
			String language = new UserDao().getEmpLanguages(emp.get(i).getId());
			String technology = new UserDao().getEmpTechnologies(emp.get(i).getId());
			String database = new UserDao().getEmployeeDatabases(emp.get(i).getId());
			languages.add(language);
			technologies.add(technology);
			databases.add(database);
			System.out.println("lans: " + language);
			System.out.println("techs: " + technology);
			System.out.println("dbs: " + database);
		}		
		req.setAttribute("employee", emp);
		req.setAttribute("languages", languages);
		req.setAttribute("technologies", technologies);
		req.setAttribute("databases", databases);
		req.getRequestDispatcher("ListAllEmployee.jsp").forward(req, resp);
//		req.setAttribute("AllHR", emp);
//		req.getRequestDispatcher("ListAllHR.jsp").forward(req, resp);
//		super.doGet(req, resp);
	}
}
