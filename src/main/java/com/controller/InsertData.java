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


@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertData() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int sid=Integer.parseInt(request.getParameter("t1"));
	   String sname = request.getParameter("t2");
	   try {
		
		   Student s1=new Student(sid, sname);
		   StudentManager sm = new StudentManager();
		   String ack=sm.inserData(s1);
		   pw.print(ack);
		   RequestDispatcher rd = request.getRequestDispatcher("index.html");
		   rd.include(request, response);
		   
	} catch (Exception e) {
		// TODO: handle exception
		pw.print(e.getMessage());
		
		
	}
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
