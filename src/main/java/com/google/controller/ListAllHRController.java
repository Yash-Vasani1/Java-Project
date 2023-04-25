package com.google.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.bean.HRBean;
import com.google.dao.UserDao;

@WebServlet("/ListAllHRController")
public class ListAllHRController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<HRBean> hrs = new UserDao().getAllHR();
		
		req.setAttribute("AllHR", hrs);
		req.getRequestDispatcher("ListAllHR.jsp").forward(req, resp);
//		super.doGet(req, resp);
	}

}
