package it.uniroma3.siw.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller")
public class SimpleController extends HttpServlet {
	private static final long serialVersionUID=1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// gestione della RICHIESTA

		// leggo i parametri e li salvo in varibili locali
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");

		// leggo (alcune) intestazioni http della richiesta
		String address = (String)request.getRemoteAddr();
		String host = (String)request.getRemoteHost();
		String userAgent = request.getHeader("User-Agent");

		// gestione dell'inoltro
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/vista");
		rd.forward(request, response);
		return; 

		
	}
}