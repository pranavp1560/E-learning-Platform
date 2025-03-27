package com.E_Learning.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.E_Learning.dao.AdmissionDao;
import com.E_Learning.model.AdmissionBean;

/**
 * Servlet implementation class UpdateAddServlet
 */
public class UpdateAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		AdmissionDao ad= new AdmissionDao();
		AdmissionBean bean=new AdmissionBean();
		
		bean.setPhone(request.getParameter("phone"));
		bean.setFirstName(request.getParameter("firstName"));
		bean.setLastName(request.getParameter("lastName"));
		bean.setMiddleName(request.getParameter("middleName"));
		bean.setMothersName(request.getParameter("mothersName"));
		bean.setAddress(request.getParameter("address"));
		bean.setEmail(request.getParameter("email"));
		bean.setEmergencyPhone(request.getParameter("emergencyPhone"));
		bean.setDob(request.getParameter("dob"));
		bean.setGender(request.getParameter("gender"));
		bean.setBatchMode(request.getParameter("batchMode"));
		bean.setCourse(request.getParameter("course"));
		System.out.println("In update"+bean.getPhone());
		boolean flag=ad.updateAdd(bean);
		if(flag!=true) {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<html><head>");
			out.println("<script type='text/javascript'>");
			out.println("alert('Student Data Updated Successfully!!')");
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
			out.println("alert('Student Data isn't Updated Successfully!!')");
			out.println("location='dashboard.jsp';");
			out.println("</script>");
			out.println("</head></html>");
			
		}
	}

}
