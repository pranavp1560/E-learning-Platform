package com.E_Learning.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.E_Learning.dao.RegisteredDao;
import com.E_Learning.model.RegisteredBean;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisteredServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisteredServlet() {
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
		String username=request.getParameter("username");
		String mobile=request.getParameter("mobile");
	    String email=request.getParameter("email");
		String password=request.getParameter("password");
		String course=request.getParameter("course");
		
	                    
		
		
		RegisteredDao rd=new RegisteredDao();
		RegisteredBean bean=new RegisteredBean();
		
		bean.setUsername(username);
		bean.setMobile(mobile);
		bean.setEmail(email);
		bean.setPassword(password);
		bean.setCourse(course);
		
		boolean flag=rd.register(bean);
		if(flag)
		{
			response.sendRedirect("signin.jsp");
		}
		
		
	}

}
