package it.uniroma3.siw.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.uniroma3.siw.model.Product;
import it.uniroma3.siw.repository.ProductRepository;

public class ProductMain {

	public static void main(String[] args) {
		ProductRepository productRepository = new ProductRepository();
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

		productRepository.setEm(em);
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		productRepository.save(product);
		productRepository.save(product1);
		tx.commit();
		List<Product> listaProdotti = productRepository.findAll();
		for(Product p:listaProdotti) {
			System.out.println(p);
		}
		em.close();
		emf.close();
	}
}