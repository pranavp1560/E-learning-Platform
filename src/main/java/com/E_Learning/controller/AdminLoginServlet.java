package com.E_Learning.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.E_Learning.dao.AdminLoginDao;
import com.E_Learning.model.AdminLoginBean;

/**
 * Servlet implementation class AdminLoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		
		AdminLoginDao abd=new AdminLoginDao();
		AdminLoginBean bean= new AdminLoginBean();
		bean.setUsername(userName);
		bean.setPassword(password);
		
		boolean flag=abd.admin(bean);
		if(flag){
			
			response.sendRedirect("dashboard.jsp");
		}
		else {
			System.out.println("fail");
		}
		
	}

}
