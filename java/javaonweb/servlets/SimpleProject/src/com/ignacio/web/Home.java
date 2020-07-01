package com.ignacio.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		String firstName="";
		String lastName="";
		String fav_language="";
		String hometown="";
		
		if(request.getParameter("firstname")!=null) {
			firstName = request.getParameter("firstname");
		}
		
		else if(request.getParameter("firstname")==null) {
			firstName = "Desconocido";
		}
		
		if(request.getParameter("lastname")!=null) {
			lastName = request.getParameter("lastname");
		}
		
		if(request.getParameter("language")!=null) {
			fav_language = request.getParameter("language");
		}
		
		if(request.getParameter("home")!=null) {
			hometown = request.getParameter("home");
		}
		
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write("<h1>Welcome, " + firstName+" "+lastName+"</h1>");
        out.write("<h2>Your favorite language is: " + fav_language + "</h2>");
        out.write("<h3>Your hometown is: " + hometown + "</h3>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}