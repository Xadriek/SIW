package it.uniroma3.siw.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.uniroma3.siw.model.Customer;

public class CustomerRepository {

	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Customer save(Customer customer) {

		if(customer.getId()!=null) {
			em.merge(customer);
		} else {
			em.persist(customer);
		}

		return customer;
	}

	public Customer findById (Long id) {

		return em.find(Customer.class, id);
	}

	public List<Customer> findAll(){

		return em.createNamedQuery("findAllCustomers", Customer.class).getResultList();
	}

	public void delete(Customer customer) {

		em.remove(customer);
	}
	
	public void deleteAll() {
		
		em.createQuery("DELETE FROM Customer").executeUpdate();
	}
	
	public Long count() {
		
		 return em.createQuery("SELECT count(p) FROM Customer p", Long.class).getSingleResult();
	}
	
	public boolean existById(Long id) {
		
		return (findById(id)!=null);
	}
	
	

}
