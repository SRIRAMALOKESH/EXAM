package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;
import com.model.StudentManager;


@WebServlet("/DeleteData")
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteData() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int sid =  Integer.parseInt( request.getParameter("t1"));
		try {
			Student s1 = new Student();
			StudentManager sm = new StudentManager();
			s1.setSid(sid);
			String ack =  sm.deletaData(s1);
			pw.print(ack);
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			doGet(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
