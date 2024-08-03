package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.dao.TaskDetailsDao;

public class DeleteTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteTaskServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TaskDetailsDao t = new TaskDetailsDao();
		try {
			System.out.println("working");
			HttpSession ss = request.getSession();
			t.deleteTask((String)ss.getAttribute("emp_name"),request.getParameter("task"), request.getParameter("date"));
			
			ss.setAttribute("tasks", t.getTasks((String) ss.getAttribute("emp_name")));
			
			response.sendRedirect("empHome.jsp");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
