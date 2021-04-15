package com.ss.dynamic.main;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;




/**
 * Servlet implementation class DynamicWebMain
 */

//@WebServlet("/DynamicWebMain")


public class DynamicWebMain extends HttpServlet {


	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DynamicWebMain() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		doPost(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		try {
			response.sendRedirect("final.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}



}


