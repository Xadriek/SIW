package it.uniroma3.siw.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma3.siw.controller.validator.PersonaValidator;
import it.uniroma3.siw.model.Persona;

@WebServlet("/controller")
public class SimpleController extends HttpServlet {
	
	private static final long serialVersionUID=1L;
	private Persona persona;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// gestione della RICHIESTA

		// leggo i parametri e li salvo in varibili locali
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String nextPage = null;

		String comando;
		comando=request.getParameter("submit");
		PersonaValidator validator=new PersonaValidator();
		HttpSession session=request.getSession();
		if(comando.equals("invia")) {
			if(validator.validate(request)) {

				persona=new Persona(nome.toUpperCase(), cognome.toUpperCase());
				session.setAttribute("persona", persona);
				nextPage="/conferma.jsp";
			}else {

				nextPage="/index.jsp";
			}
		}else {
			if(comando.equals("conferma")) {
				nextPage="/persona.jsp";
			}else if(comando.equals("torna indietro")) {
				session.setAttribute("persona", persona);
				nextPage="/index.jsp";

			}
		}
		request.setAttribute("cognome", cognome);
		request.setAttribute("nome", nome);

		// gestione dell'inoltro
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return; 


	}
}