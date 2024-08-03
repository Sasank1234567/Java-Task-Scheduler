package com.servlets;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.EmployeeDao;

public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public AddEmployeeServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao e=new EmployeeDao();
		e.addEmployee(request.getParameter("id"), request.getParameter("name"), request.getParameter("password"));
		response.sendRedirect("adminHome.jsp");
	}

}
