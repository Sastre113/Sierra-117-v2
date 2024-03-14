package sierra.dao;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class GenericDao<T extends Serializable> implements IGenericDAO<T> {
	
	@PersistenceContext(unitName = "sierra117EntityManagerFactory")
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<T> findAll(final T clazz) {
		return this.entityManager.createQuery("from " + clazz.getClass().getName()).getResultList();
	}

	public T create(final T entity) {
		this.entityManager.persist(entity);
		return entity;
	}
	
	public <K> T findById(Class<T> clazz, final K id) {
		return this.entityManager.find(clazz, id);
	}

	public T update(final T entity) {
		return this.entityManager.merge(entity);
	}

	public void delete(final T entity) {
		this.entityManager.remove(entity);
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}
}
