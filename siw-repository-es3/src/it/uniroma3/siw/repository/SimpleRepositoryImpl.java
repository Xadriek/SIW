package it.uniroma3.siw.repository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.EntityManager;

public class SimpleRepositoryImpl<T> implements SimpleRepository<T> {
	private EntityManager em;
	private Class<T> domainClass;

	public SimpleRepositoryImpl(Class<T> domainClass) {
		
		this.domainClass = domainClass;
	}

	public T save(T entity) {
		
		T persistentEntity =entity;
		Method getId = null; 
		
		try {
			getId = this.domainClass.getMethod("getId");
		}
		catch (NoSuchMethodException e) {

			e.printStackTrace();

		} 
		catch (SecurityException e) {

			e.printStackTrace();
		}

		try {
			if(getId.invoke(persistentEntity)!= null ) {

				this.em.merge(persistentEntity);

			}else { 

				this.em.persist(persistentEntity);
			}
		} 
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		catch (InvocationTargetException e) {
			e.printStackTrace();
		}




		return persistentEntity;
	}

	public List<T> findAll() { 
		return em.createQuery("select o from " + this.domainClass.getName() + " o", this.domainClass).getResultList();
	}	

	public T findById(Long id){
		return em.find(this.domainClass, id); 
	}

	public void delete(T t){
		this.em.remove(t);
	}

	public void deleteAll(){
		this.em.createQuery("DELETE FROM "+this.domainClass.getName()).executeUpdate();
	}

	public long count() {
		return (long)this.em.createQuery("SELECT COUNT(id) FROM "+this.domainClass.getName()).getSingleResult();
	}

	public boolean existsById(Long id) {
		return (this.findById(id)!=null);
	}

	@Override
	public EntityManager getEntityManager() {
		return this.em;
	}

	@Override
	public void setEntityManager(EntityManager em) {
		this.em=em;

	}

}
