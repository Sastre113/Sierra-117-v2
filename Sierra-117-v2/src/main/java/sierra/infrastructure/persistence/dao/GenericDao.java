package sierra.infrastructure.persistence.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class GenericDao implements IGenericDAO {
	
	@PersistenceContext(unitName = "sierra117EntityManagerFactory")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T extends Serializable> List<T> findAll(final Class<T> clazz) {
		return this.entityManager.createQuery("from " + clazz.getName()).getResultList();
	}

	@Override
	public <T extends Serializable> T create(final T entity) {
		this.entityManager.persist(entity);
		return entity;
	}
	
	@Override
	public <K, T extends Serializable> T findById(Class<T> clazz, final K id) {
		return this.entityManager.find(clazz, id);
	}

	@Override
	public Serializable update(final Serializable entity) {
		return this.entityManager.merge(entity);
	}

	@Override
	public void delete(final Serializable entity) {
		this.entityManager.remove(entity);
	}	
}