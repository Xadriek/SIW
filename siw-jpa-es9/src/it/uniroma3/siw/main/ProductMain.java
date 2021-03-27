package it.uniroma3.siw.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.*;

import it.uniroma3.siw.model.Product;

public class ProductMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		EntityManager em = emf.createEntityManager();
		
		Product product = new Product();
		product.setName("KRIDDIG");
		product.setPrice(3.5F);
		product.setDescription("A wonderful bla bla");
		product.setCode("pt000154");

		Product product1 = new Product();
		product1.setName("SIW");
		product1.setPrice(5.5F);
		product1.setCode("ab0045");
		product1.setDescription("interessante");
		
		Product product2 = new Product();
		product2.setName("RubberDucky");
		product2.setPrice(50.5F);
		product2.setDescription("Fa i danni a colori");
		product2.setCode("ab5545");
		
		Product product3 = new Product();
		product3.setName("RaspBerry");
		product3.setPrice(110.5F);
		product3.setDescription("Ci fai tutto");
		product3.setCode("ab6945");
		
		Product product4 = new Product();
		product4.setName("flipperZero");
		product4.setPrice(105.5F);
		product4.setDescription("Tamagochi per nerd");
		product4.setCode("ab9945");
		
		Product product5 = new Product();
		product5.setName("SharkJack");
		product5.setPrice(120.5F);
		product5.setDescription("dategli una porta ethernet lui farà il resto");
		product5.setCode("ef000154");

		Product product6 = new Product();
		product6.setName("XPS");
		product6.setPrice(2050.8F);
		product6.setCode("ef0045");
		product6.setDescription("è meglio di un Macbook");
		
		Product product7 = new Product();
		product7.setName("WifiPineapple");
		product7.setPrice(105.5F);
		product7.setDescription("Fa i danni a colori");
		product7.setCode("ef5545");
		
		Product product8 = new Product();
		product8.setName("casio");
		product8.setPrice(50.5F);
		product8.setDescription("oggetto di classe");
		product8.setCode("ef6945");
		
		Product product9 = new Product();
		product9.setName("GpsLocator");
		product9.setPrice(120.5F);
		product9.setDescription("Non puoi nasconderti");
		product9.setCode("ef9945");

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(product);
		em.persist(product1);
		em.persist(product2);
		em.persist(product3);
		em.persist(product4);
		em.persist(product5);
		em.persist(product6);
		em.persist(product7);
		em.persist(product8);
		em.persist(product9);
		tx.commit();
		
		Map<Float,Long> price2cont= new HashMap<Float,Long>();
		TypedQuery<Object[]> q= em.createQuery("SELECT p.price, count(p) FROM Product p GROUP BY p.price ORDER BY p.price desc",Object[].class);
		System.out.println("MAPPA PRODOTTI PER PREZZO");
		
		String separatore = "------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
		for(Object[] o:q.getResultList()) {
			price2cont.put((Float)o[0],(Long)o[1]);
			System.out.println(separatore);
			System.out.println((Float)o[0]);
			System.out.println(price2cont.get((Float)o[0]));
			System.out.println(separatore);
		}
		System.out.println("DESCRIZIONI PRODOTTI PREZZI MASSIMI");
		TypedQuery<Object> massimo= em.createQuery("SELECT max(p.price) FROM Product p",Object.class);
		TypedQuery<Object[]> q2= em.createQuery("SELECT p.id,p.name,p.description,p.code,p.price FROM Product p GROUP BY p.id,p.price HAVING p.price = :massimo ",Object[].class);
		q2.setParameter("massimo", (Float)massimo.getSingleResult());
		for(Object[] o:q2.getResultList()) {
			System.out.println(separatore);
			for(Object o2:o) {
				System.out.println(o2);
			}
			System.out.println(separatore);
			
		}
		System.out.println("DESCRIZIONI PRODOTTI PREZZI MINIMI");
		TypedQuery<Object> minimo= em.createQuery("SELECT min(p.price) FROM Product p",Object.class);
		TypedQuery<Object[]> q3= em.createQuery("SELECT p.id,p.name,p.description,p.code,p.price FROM Product p GROUP BY p.id,p.price HAVING p.price = :minimo ",Object[].class);
		q3.setParameter("minimo", (Float)minimo.getSingleResult());
		for(Object[] o:q3.getResultList()) {
			System.out.println(separatore);
			for(Object o2:o) {
				System.out.println(o2);
			}
			System.out.println(separatore);
		}
		
		em.close();
		emf.close();
	}
}