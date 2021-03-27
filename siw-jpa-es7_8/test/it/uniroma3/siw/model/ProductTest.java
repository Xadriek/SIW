package it.uniroma3.siw.model;

import static org.junit.Assert.assertEquals;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;
	private Query deleteQuery;
	private int deletedRows;
	@BeforeAll
	public static void initEntityManager() throws Exception {
		emf = Persistence.createEntityManagerFactory("products-unit-test");
		em = emf.createEntityManager();
	}

	@AfterAll
	public static void closeEntityManager() throws SQLException {
		if (em != null)
			em.close();
		if (emf != null)
			emf.close();
	}

	@BeforeEach
	public void initTransaction() {
		Product product = new Product();
		product.setName("KRIDDIG");
		product.setPrice(3.5F);
		product.setDescription("A wonderful bla bla");
		product.setCode("pt000154");

		Product product1 = new Product();
		product1.setName("SIW");
		product1.setPrice(5.5F);
		product1.setCode("ab0045");
		deleteQuery=em.createNamedQuery("deleteAllProducts");
		tx = em.getTransaction();
		tx.begin();
		deletedRows=deleteQuery.executeUpdate();
		tx.commit();
		tx.begin();
		em.persist(product);
		em.persist(product1);
		tx.commit();
	}
	@Test
	public void cancellazioneSelezioneNamedQuery() {

		List<Product> products = em.createNamedQuery("findAllProducts", Product.class).getResultList();
		assertEquals(2, products.size());
		tx.begin();
		deletedRows=deleteQuery.executeUpdate();
		tx.commit();
		em.clear();
		assertEquals(2,deletedRows);
		products = em.createNamedQuery("findAllProducts", Product.class).getResultList();
		assertEquals(0,products.size());
	}
	@Test
	public void cancellazioneSelezioneDynamicQuery() {

		List<Product> products = em.createQuery("SELECT p FROM Product p",Product.class).getResultList();
		assertEquals(2, products.size());
		deleteQuery=em.createQuery("DELETE FROM Product p");
		tx.begin();
		deletedRows=deleteQuery.executeUpdate();
		tx.commit();
		em.clear();
		assertEquals(2,deletedRows);
		products = em.createQuery("SELECT p FROM Product p",Product.class).getResultList();
		assertEquals(0,products.size());
	}
	@SuppressWarnings("unchecked")
	@Test
	public void cancellazioneSelezioneNativeQuery() {

		List<Product> products = em.createNativeQuery("SELECT * FROM product",Product.class).getResultList();
		assertEquals(2, products.size());
		deleteQuery=em.createNativeQuery("DELETE FROM product");
		tx.begin();
		deletedRows=deleteQuery.executeUpdate();
		tx.commit();
		em.clear();
		assertEquals(2,deletedRows);
		products = em.createNativeQuery("SELECT* FROM product",Product.class).getResultList();
		assertEquals(0,products.size());
	}

}