package it.uniroma3.siw.main;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import it.uniroma3.siw.model.Product;

public class ProductMain {

		private static float valore;
		private static Scanner scanner;
		private static TypedQuery<Product> query;
		
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
		product4.setPrice(68.9F);
		product4.setDescription("Tamagochi per nerd");
		product4.setCode("ab9945");

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(product);
		em.persist(product1);
		em.persist(product2);
		em.persist(product3);
		em.persist(product4);
		tx.commit();

		scanner=new Scanner(System.in);
		System.out.println("INSERISCI VALORE");
		valore=scanner.nextFloat();
		query=em.createQuery("SELECT p FROM Product p WHERE p.price < :valore",Product.class);
		query.setParameter("valore",valore);
		List<Product> resultList= query.getResultList();
		for(Product t:resultList) {
			System.out.println(t);
		}
		em.close();
		emf.close();
	}
}