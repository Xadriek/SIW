package it.uniroma3.siw.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductMain {

	private static final Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		EntityManager em = emf.createEntityManager();
		
		logger.trace("This is a Trace message");
        logger.debug("This is a Debug message");
        logger.info("This is an Info message");
        logger.warn("This is a Warn message");
        logger.error("This is an Error message");
        logger.fatal("This is a Fatal message");
		
		
		
		em.close();
		emf.close();
	}
}