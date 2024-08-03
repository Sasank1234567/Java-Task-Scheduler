package com.servlets;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.ManagerDao;

public class MonthlyDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MonthlyDetailsServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss=request.getSession();
		ManagerDao e=new ManagerDao();
		ss.setAttribute("monthly", e.monthlyDetails(request.getParameter("username")));
		response.sendRedirect("monthlyDetails.jsp");
	}

}
