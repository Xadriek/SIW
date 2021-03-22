package it.uniroma3.siw.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.uniroma3.siw.model.Address;
import it.uniroma3.siw.model.Customer;
import it.uniroma3.siw.model.Order;
import it.uniroma3.siw.model.OrderLine;

public class ProductMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		EntityManager em = emf.createEntityManager();
		
		/*
		Customer customer= new Customer();						//genero il cliente
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
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(customer);
		tx.commit();
		tx.begin();
		em.remove(customer);
		customer.setLastName("gino");
		tx.commit();
		tx.begin();
		em.persist(customer);
		tx.commit();*/
		
		
		em.close();
		emf.close();
	}
}