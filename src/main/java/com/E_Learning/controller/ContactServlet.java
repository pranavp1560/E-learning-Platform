package com.E_Learning.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.E_Learning.dao.ContactDao;
import com.E_Learning.model.ContactBean;

/**
 * Servlet implementation class ContactServlet
 */
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlet() {
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
		String email=request.getParameter("email");
		String sub=request.getParameter("sub");
		String message=request.getParameter("message");
		
		ContactDao cd=new ContactDao();
		ContactBean bean=new ContactBean();
		
		bean.setUsername(username);
		bean.setEmail(email);
		bean.setSub(sub);
		bean.setMessage(message);
		
		boolean flag=cd.contact(bean);
		if(flag=true) {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<html><head>");
			out.println("<script type='text/javascript'>");
			out.println("alert('Message Sent Successfully!!')");
			out.println("location='index.jsp';");
			out.println("</script>");
			out.println("</head></html>");
			
			
			request.setAttribute("bean", flag);
			//request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}
		else {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<html><head>");
			out.println("<script type='text/javascript'>");
			out.println("alert('Please try again !!')");
			out.println("location='index.jsp';");
			out.println("</script>");
			out.println("</head></html>");
			
		}
	}

}
