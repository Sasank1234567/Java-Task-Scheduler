package com.servlets;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.ManagerDao;

public class MangLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public MangLoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession ss=request.getSession();
			String s=new ManagerDao().managerLogin(request.getParameter("username"), request.getParameter("password"));
			ss.setAttribute("mang_name",s );
			response.sendRedirect("mangHome.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
