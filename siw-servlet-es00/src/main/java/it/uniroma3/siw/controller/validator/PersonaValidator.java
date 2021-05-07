package it.uniroma3.siw.controller.validator;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.siw.model.Persona;

public class PersonaValidator {



	public boolean validate(HttpServletRequest request) {

		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		Persona persona= new Persona(nome,cognome);
		Map<String,String> messaggiErrore=new HashMap<String,String>();

		if(!nome.equals("") && !cognome.equals("")) {

			return true;

		}else {
			if(nome.equals("")) {	
				messaggiErrore.put("nome", "Il nome è un campo obbligatorio");
				request.setAttribute("cognome", persona.getCognome());
			}
			if(cognome.equals("")) {

				messaggiErrore.put("cognome", "Il cognome è un campo obbligatorio");
				request.setAttribute("nome", persona.getNome());
			}
			request.setAttribute("errori", messaggiErrore);
			return false;
		}
	}


}
