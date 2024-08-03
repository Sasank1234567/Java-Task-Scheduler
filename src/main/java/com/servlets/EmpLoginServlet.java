package com.servlets;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.dao.EmployeeDao;
import com.entity.TaskDetails;

/**
 * Servlet implementation class LoginServlet
 */
public class EmpLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao e=new EmployeeDao();
		try {
			
			List<TaskDetails> l=e.login(request.getParameter("username"), request.getParameter("password"));
			
			if(e.isLogin()){
				System.out.println("login successfull");
				HttpSession ss=request.getSession();
				ss.setAttribute("tasks", l);
				ss.setAttribute("emp_name", request.getParameter("username"));
				response.sendRedirect("empHome.jsp");
			}else {
				response.setContentType("text/html");
				PrintWriter p=response.getWriter();
				p.print("<h1>failed - <a href=\"javascript:history.back()\">back</a></h1> ");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

}
