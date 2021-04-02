package it.uniroma3.siw.repository;

import java.util.List;

import javax.persistence.EntityManager;

import it.uniroma3.siw.model.Provider;

public class ProviderRepository {

	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Provider save(Provider provider) {

		if(provider.getId()!=null) {
			em.merge(provider);
		} else {
			em.persist(provider);
		}

		return provider;
	}

	public Provider findById (Long id) {

		return em.find(Provider.class, id);
	}

	public List<Provider> findAll(){

		return em.createNamedQuery("findAllProviders", Provider.class).getResultList();
	}

	public void delete(Provider provider) {

		em.remove(provider);
	}
	
	public void deleteAll() {
		
		em.createQuery("DELETE FROM Provider").executeUpdate();
	}
	
	public Long count() {
		
		 return em.createQuery("SELECT count(pr) FROM Provider pr", Long.class).getSingleResult();
	}
	
	public boolean existById(Long id) {
		
		return (findById(id)!=null);
	}
	
	

}
