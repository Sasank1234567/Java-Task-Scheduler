package com.servlets;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.TaskDetailsDao;
import com.entity.TaskDetails;

public class AddTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddTaskServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaskDetails t=new TaskDetails();
		TaskDetailsDao td=new TaskDetailsDao();
		t.setName(request.getParameter("name"));
		t.setDate(request.getParameter("date"));
		t.setTask(request.getParameter("task"));
		t.setStart_time(request.getParameter("start"));
		t.setEnd_time(request.getParameter("end"));
		td.addTask(t);
		response.sendRedirect("mangHome.jsp");
	}

}
