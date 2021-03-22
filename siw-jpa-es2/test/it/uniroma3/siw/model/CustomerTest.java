package it.uniroma3.siw.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;
	private Customer customer;

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
		tx = em.getTransaction();
		
		this.customer= new Customer();						//genero il cliente
		Address address1=new Address();							//genero l'oggetto address
		
		address1.setStreet("piazza del gigante Fondatore");		//
		address1.setCity("Shiganshina");							//
		address1.setZipcode("006969");							//
		address1.setCountry("Paradise");							//setting di address					
		
		customer.setFirstName("nomeCliente1");					//
		customer.setLastName("cognomeCliente1");				//
		customer.setEmail("cliente1@clienti.com");				//
		customer.setAddress(address1);							//setting di custome
		
		OrderLine orderLine1=new OrderLine();					//creazione di linee d'ordine
		OrderLine orderLine2=new OrderLine();					//
		
		Order order1=new Order();								//creazione ordini
		Order order2=new Order();								//
		
		List<OrderLine> orderLines=new ArrayList<OrderLine>(); 	//istanziamento lista di linee d'ordine
		orderLines.add(orderLine1);								//
		orderLines.add(orderLine2);								// e inserimento linee d'ordine
		
		order1.setOrderLines(orderLines);						//inserimenti linee d'ordine dell'ordine
		order2.setOrderLines(orderLines);
		
		List<Order> payedOrders=customer.getPayedOrders();		//istaziamento lista di ordini pagati
		payedOrders.add(order1);								//inserimento ordini pagati

		List<Order> orders=customer.getOrders();				//istanziamento lista ordini
		orders.add(order2);										//inserimento ordini
		
		customer.setOrders(orders);
		customer.setPayedOrders(payedOrders);
	}
	
	/*@Test
	public void creazioneTest() {
		
		tx.begin();
		em.persist(customer);
		tx.commit();
		assertNotNull("ID should not be null", customer.getId());
	}
	
	@Test
	public void haveOrders() {
		
		tx.begin();
		em.persist(customer);
		tx.commit();
		List<Order> orders= em.createNamedQuery("findAllOrders",Order.class ).getResultList();
		assertEquals(2,orders.size());
	}*/
	/*@Test
	public void wissel() {
		tx.begin();
		em.persist(customer);
		tx.commit();
		tx.begin();
		em.remove(customer);
		customer.setLastName("gino");
		tx.commit();
		tx.begin();
		em.persist(customer);
		tx.commit();
		List<Customer> customers=em.createNamedQuery("findAllCustomers",Customer.class).getResultList();
		assertEquals("gino",customers.get(0).getLastName());
		
	}*/
}
