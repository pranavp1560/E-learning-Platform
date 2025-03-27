package com.E_Learning.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.E_Learning.dao.StudentsViewDao;
import com.E_Learning.model.AdmissionBean;

/**
 * Servlet implementation class StudentViewServlet
 */
public class StudentsViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentsViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub
	 * response.getWriter().append("Served at: ").append(request.getContextPath());
	 * }
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String course = request.getParameter("course");
		request.setAttribute("course", course);
    //    System.out.println("Selected Course: " + course); // Debug statement

        StudentsViewDao sv = new StudentsViewDao();
        List<AdmissionBean> students = sv.studentsViewByCourse(course);
        //AdmissionBean b=sv.addfee(course);
        
       // students.add(b);
       // System.out.println("Number of students found: " + (students != null ? students.size() : 0)); // Debug statement

        if (students != null) {
            request.setAttribute("students", students);
            request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
	}

}
