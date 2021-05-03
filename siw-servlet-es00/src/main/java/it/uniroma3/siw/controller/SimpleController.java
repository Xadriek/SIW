package it.uniroma3.siw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

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
		String nextPage;
		Map<String,String> messaggiErrore=new HashMap<String,String>();

		if(!nome.equals("") && !cognome.equals("")) {

			request.setAttribute("nome", nome.toUpperCase());
			request.setAttribute("cognome", cognome.toUpperCase());
			nextPage="/persona.jsp";
		}else {
			if(nome.equals("")) {	
				messaggiErrore.put("nome", "Il nome è un campo obbligatorio");	
			}
			if(cognome.equals("")) {

				messaggiErrore.put("cognome", "Il cognome è un campo obbligatorio");	
			}
			request.setAttribute("errori", messaggiErrore);
			nextPage="/index.jsp";
		}

		// gestione dell'inoltro
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return; 


	}
}