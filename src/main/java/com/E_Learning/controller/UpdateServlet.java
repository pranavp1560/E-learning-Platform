package com.E_Learning.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.E_Learning.dao.AdminLoginDao;
import com.E_Learning.dao.AdmissionDao;
import com.E_Learning.model.AdminLoginBean;
import com.E_Learning.model.AdmissionBean;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		String phone=request.getParameter("phone");
		
		System.out.println(phone);
		
		
		AdmissionDao ad= new AdmissionDao();
		AdmissionBean bean=new AdmissionBean();
		
		bean.setPhone(phone);
		
		AdmissionBean flag=ad.update(bean);
		if(flag!=null){
			System.out.println(bean.getAddress());
			request.setAttribute("bean", flag);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
		else {
			System.out.println("fail");
		}
		
		
	}

}
