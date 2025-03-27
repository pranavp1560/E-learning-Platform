package com.E_Learning.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.E_Learning.dao.AdmissionDao;
import com.E_Learning.model.AdmissionBean;

/**
 * Servlet implementation class AdmissionServlet
 */
public class AdmissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmissionServlet() {
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
		String firstName=request.getParameter("firstName");
		String middleName=request.getParameter("middleName");
		String lastName=request.getParameter("lastName");
		String mothersName=request.getParameter("mothersName");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String emergencyPhone=request.getParameter("emergencyPhone");
		String dob=request.getParameter("dob");
		String gender=request.getParameter("gender");
		String batchMode=request.getParameter("batchMode");
		String course=request.getParameter("course");
		
		
		AdmissionDao ad= new AdmissionDao();
		AdmissionBean bean=new AdmissionBean();
		
		bean.setFirstName(firstName);
		bean.setMiddleName(middleName);
		bean.setLastName(lastName);
		bean.setMothersName(mothersName);
		bean.setAddress(address);
		bean.setEmail(email);
		bean.setPhone(phone);
		bean.setEmergencyPhone(emergencyPhone);
		bean.setDob(dob);
		bean.setGender(gender);
		bean.setBatchMode(batchMode);
		bean.setCourse(course);
		
		boolean flag=ad.admission(bean);
		if(flag){
			
			response.sendRedirect("payment.jsp");
		}
		else {
			System.out.println("fail");
		}
		
		
	}

}
