package com.servlets;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.ManagerDao;

public class AddManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddManagerServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerDao e=new ManagerDao();
		e.addManager(request.getParameter("id"), request.getParameter("name"), request.getParameter("password"));
		response.sendRedirect("adminHome.jsp");
	}

}
