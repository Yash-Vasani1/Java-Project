package com.google.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.bean.HRBean;
import com.google.dao.UserDao;

@WebServlet("/ViewHRController")
public class ViewHRController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.valueOf(req.getParameter("id"));
		HRBean hr = new UserDao().getHRbyid(id);
		
		req.setAttribute("hr", hr);
		req.getRequestDispatcher("ViewHR.jsp").forward(req, resp);
//		super.doGet(req, resp);
	}

}
