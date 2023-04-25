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

@WebServlet("/DeleteHRController")
public class DeleteHRController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.valueOf(req.getParameter("id"));
		new UserDao().deleteHR(id);
		resp.sendRedirect("ListAllHRController");
		
//		ArrayList<HRBean> hrlist = new UserDao().getAllHR();
//		System.out.println("This names from arraylist: ");
//		for(HRBean hr:hrlist)
//		{
//			System.out.println(hr.getName());
//		}
//		req.setAttribute("AllHR", hrlist);
//		req.getRequestDispatcher("ListAllHR.jsp").forward(req, resp);
//		super.doGet(req, resp);
	}
}
