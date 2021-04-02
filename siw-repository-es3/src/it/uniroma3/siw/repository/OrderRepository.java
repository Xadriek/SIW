package it.uniroma3.siw.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.uniroma3.siw.model.Order;

public class OrderRepository {

	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Order save(Order order) {

		if(order.getId()!=null) {
			em.merge(order);
		} else {
			em.persist(order);
		}

		return order;
	}

	public Order findById (Long id) {

		return em.find(Order.class, id);
	}

	public List<Order> findAll(){

		return em.createNamedQuery("findAllOrder", Order.class).getResultList();
	}

	public void delete(Order order) {

		em.remove(order);
	}
	
	public void deleteAll() {
		
		em.createQuery("DELETE FROM Order").executeUpdate();
	}
	
	public Long count() {
		
		 return em.createQuery("SELECT count(o) FROM Order o", Long.class).getSingleResult();
	}
	
	public boolean existById(Long id) {
		
		return (findById(id)!=null);
	}
	
	

}
