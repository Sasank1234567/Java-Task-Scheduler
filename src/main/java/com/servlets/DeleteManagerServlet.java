package com.servlets;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.ManagerDao;

public class DeleteManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DeleteManagerServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerDao e=new ManagerDao();
		e.deleteManager(request.getParameter("name"));
		response.sendRedirect("adminHome.jsp");
	}

}
