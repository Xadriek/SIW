

import java.util.List;

import javax.persistence.EntityManager;

public interface SimpleRepository<T> {

	public EntityManager getEntityManager();

	public void setEntityManager(EntityManager em);

	public T save(T entity);

	public List<T> findAll();

	public T findById(Long id);

	public void delete(T t);

	public void deleteAll();

	public Long count();

	public boolean existsById(Long id);
}
