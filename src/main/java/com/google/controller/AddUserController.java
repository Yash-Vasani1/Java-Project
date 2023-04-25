package com.google.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.bean.EmployeeBean;
import com.google.dao.UserDao;

@WebServlet("/AddUserController")
public class AddUserController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String name = req.getParameter("name");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
//		String password = req.getParameter("password");
//		System.out.println("Number which come from form: " + req.getParameter("number"));
		Integer number = Integer.valueOf(req.getParameter("number"));
//		System.out.println("After convert that string into integer: " + number);
		Integer experience = Integer.valueOf(req.getParameter("experience"));
		String resumeurl = req.getParameter("resumeurl");
		String languages = req.getParameter("lan");
		String databases = req.getParameter("db");
		String technologies = req.getParameter("tech");
		
//		System.out.println("--------values from table-----------");
//		System.out.println(languages);
//		System.out.println(technologies);
//		System.out.println(databases);
//		System.out.println("---------------------------------");
		
		String[] lanarr = languages.split(",");
		String[] techarr = technologies.split(",");
		String[] dbarr = databases.split(",");
//		System.out.println("--------values from table-----------");
//		System.out.println(lanarr[0]);
//		System.out.println(techarr[0]);
//		System.out.println(dbarr[0]);
//		System.out.println("---------------------------------");
		EmployeeBean ebean = new EmployeeBean();
		ebean.setName(name);
		ebean.setEmail(email);
		ebean.setNumber(number);
		ebean.setExperience(experience);
		ebean.setResumeurl(resumeurl);
		
		int eid = new UserDao().AddEmployee(ebean);
		System.out.println("id from con: " + eid);
		
//		System.out.println("\n\nArrLanguages are: ");
		for(int i=0;i<lanarr.length;i++)
		{
			lanarr[i] = lanarr[i].trim().toLowerCase();
			int lid = new UserDao().AddLanguage(lanarr[i]);
			new UserDao().AddEmpLanguage(eid,lid);
//			System.out.println("language id from con: " + lid);
		}
		for(int i=0;i<techarr.length;i++)
		{
			techarr[i] = techarr[i].trim().toLowerCase();
			int tid = new UserDao().AddTechnology(techarr[i]);
			new UserDao().AddEmpTechnology(eid,tid);
//			System.out.println("language id from con: " + tid);
		}
		for(int i=0;i<dbarr.length;i++)
		{
			dbarr[i] = dbarr[i].trim().toLowerCase();
			int did = new UserDao().AddDatabase(dbarr[i]);
			new UserDao().AddEmpDatabase(eid,did);
//			System.out.println("language id from con: " + lid);
		}
//		System.out.println("Done !!");
		resp.sendRedirect("ListAllEmployeeController");
//		req.getRequestDispatcher("ListAllEmployeeController").forward(req, resp);
//		System.out.println("\n\nArrLanguages are: ");
//		for(int i=0;i<lanarr.length;i++)
//		{
//			System.out.println(lanarr[i].trim().toLowerCase());
//		}
		
//		System.out.println("\n\nArrLanguages are: ");
//		for(int i=0;i<lanarr.length;i++)
//		{
//			System.out.println(lanarr[i].trim().toLowerCase());
//		}
		
//		System.out.println("name: " + name );
//		System.out.println("email: " + email);
//		System.out.println("password: " + password);
//		System.out.println("number: " + number);
//		System.out.println("experience: " + experience);
//		System.out.println("resume: " + resumeurl);
//		System.out.println("\n\n Languages are: " + languages);
//		System.out.println("\n\n Technologies are: " + technologies);
//		System.out.println("\n\n databases are: ");
//		System.out.println();
//		for(int i=0;i<languages.length;i++)
//		{
//			System.out.println(languages[i]);
//		}
		
//		for(int i=0;i<technologies.length;i++)
//		{
//			System.out.println(technologies[i]);
//		}
//		for(int i=0;i<databases.length;i++)
//		{
//			System.out.println(databases[i]);
//		}
		
//		System.out.println("Hello dear1: " + req.getParameter("name"));
//		super.doPost(req, resp);
	}

}
