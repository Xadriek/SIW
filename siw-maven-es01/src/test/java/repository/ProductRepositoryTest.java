package it.uniroma3.siw.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.siw.model.Product;

@SuppressWarnings("unused")
class ProductRepositoryTest {

	private static ProductRepository prRepository; 
	private static EntityManagerFactory emf; 
	private static EntityManager em;
	private static Product prod1; 
	private static Product prod2;

	/*creazione e inizializzazione di oggetti*/ 
	@BeforeAll
	public static void setUp() {
		
		prRepository = new ProductRepository();
		emf = Persistence.createEntityManagerFactory("products-unit-test");
		em = emf.createEntityManager();
		prRepository.setEntityManager(em);

	}

	@SuppressWarnings("static-access")
	@BeforeEach
	public void afterTest() {
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		this.prRepository.deleteAll();
		
		tx.commit();
		
		assertEquals(0,this.prRepository.count());
		prod1 = new Product("confezione sushi");
		prod2 = new Product("maionese");
		
		assertNull(prod1.getId());
		assertNull(prod2.getId());
	}


	@Test
	public void saveTest_prod1NonAncoraNelDatabase() {
		
		assertNull (prod1.getId());
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		@SuppressWarnings("static-access")
		Product prodottoAtteso = this.prRepository.save(prod1);
		
		tx.commit();
		
		assertEquals(prod1, prodottoAtteso);
		assertNotNull (prod1.getId());	
	}

	@SuppressWarnings("static-access")
	@Test
	public void findByIdTest_unElementoNelDatabase() {
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		this.prRepository.save(prod2);
		
		tx.commit();
		
		Long id = prod2.getId();
		assertEquals(prod2, this.prRepository.findById(id));
	}

	@SuppressWarnings("static-access")
	@Test
	public void findAll_dueElementiNelDatabase() {
		
		assertNull(prod1.getId());
		assertNull(prod2.getId());
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		this.prRepository.save(prod1);
		this.prRepository.save(prod2);
		
		tx.commit();
		
		assertNotNull(prod1.getId());
		assertNotNull(prod2.getId());
		assertEquals(2,this.prRepository.count());
		
		List<Product> prodottiNelDB = this.prRepository.findAll();
		
		assertEquals(2, prodottiNelDB.size());
	}
}
