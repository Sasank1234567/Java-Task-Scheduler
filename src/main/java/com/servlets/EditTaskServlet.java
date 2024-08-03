package com.servlets;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.TaskDetailsDao;

public class EditTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EditTaskServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			try {
				
				HttpSession ss=request.getSession();
				TaskDetailsDao t=new TaskDetailsDao();
				System.out.println((String)ss.getAttribute("emp_name"));
				t.updateTask(request.getParameter("name"), request.getParameter("task"), request.getParameter("date"), request.getParameter("start"), request.getParameter("end"));
				ss.setAttribute("tasks", t.getTasks((String)ss.getAttribute("emp_name")));
				response.sendRedirect("empHome.jsp");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		
	}

}
