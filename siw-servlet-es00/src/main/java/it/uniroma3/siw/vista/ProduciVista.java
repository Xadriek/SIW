package it.uniroma3.siw.vista;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vista")
public class ProduciVista extends HttpServlet {
	
	private static final long serialVersionUID=1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// gestione della RISPOSTA
		// gestione della RISPOSTA

		// preparo il tipo (HTML)
		response.setContentType("text/html");
		// preparo un oggetto su cui scrivere la risposta
		PrintWriter out = response.getWriter();

		// scrivo il corpo
		out.println("<!DOCTYPE html>"); out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\" />");
		out.println("<title>mostra parametri</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Dati inseriti nella form</h1>");
		out.println("<ul>");
		out.println("<li>Nome: <b>"+request.getParameter("nome")+"</b></li>");
		out.println("<li>Cognome: <b>"+request.getParameter("cognome")+"</b></li>");
		out.println("</ul>");
		out.println("</body>\n</html> ");
	}
}