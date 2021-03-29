package it.uniroma3.siw.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.uniroma3.siw.model.Product;

public class ProductRepository {

	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Product save(Product product) {

		if(product.getId()!=null) {
			em.merge(product);
		} else {
			em.persist(product);
		}

		return product;
	}

	public Product findById (Long id) {

		return em.find(Product.class, id);
	}

	public List<Product> findAll(){

		return em.createNamedQuery("findAllProducts", Product.class).getResultList();
	}

	public void delete(Product product) {

		em.remove(product);
	}
	
	public void deleteAll() {
		
		em.createQuery("DELETE FROM Product").executeUpdate();
	}
	
	public Long count() {
		
		 return em.createQuery("SELECT count(p) FROM Product p", Long.class).getSingleResult();
	}
	
	public boolean existById(Long id) {
		
		return (findById(id)!=null);
	}
	
	

}
