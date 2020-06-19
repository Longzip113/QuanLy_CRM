package com.longnguyen.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin2")
public class HomeController extends HttpServlet{
	
	private static final long serialVersionUID = -2803907434929522296L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/admin/user/listuser.jsp").forward(req, resp);
	}
	

}
