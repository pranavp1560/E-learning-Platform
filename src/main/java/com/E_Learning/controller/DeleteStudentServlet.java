package com.E_Learning.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.E_Learning.dao.AdmissionDao;
import com.E_Learning.model.AdmissionBean;

/**
 * Servlet implementation class DeleteStudentServlet
 */
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone=request.getParameter("phone");
		
		System.out.println(phone);
		
		
		AdmissionDao ad= new AdmissionDao();
		AdmissionBean bean=new AdmissionBean();
		
		bean.setPhone(phone);
		
		boolean flag=ad.deleteStudent(bean);
		if(flag!=true){
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<html><head>");
			out.println("<script type='text/javascript'>");
			out.println("alert('Student Removed Successfully')");
			out.println("location='dashboard.jsp';");
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
			out.println("alert('Student doesn't removed Successfully')");
			out.println("location='dashboard.jsp';");
			out.println("</script>");
			out.println("</head></html>");
			
		}
	}

}
