package com.E_Learning.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.E_Learning.dao.LoginDao;
import com.E_Learning.model.RegisteredBean;

/**
 * Servlet implementation class loginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String mobile=request.getParameter("mobile");
		 String password=request.getParameter("password");
		
		 String pass="root";
		RegisteredBean bean=new RegisteredBean();
		LoginDao ld=new LoginDao();
		bean.setMobile(mobile);
		bean.setPassword(password);
		
		boolean flag=ld.login(bean);
		if(flag)
		{
			response.sendRedirect("form.jsp");
		}
		else {
			System.out.println("Failed to sign in");
		}
		
	}
	

}
