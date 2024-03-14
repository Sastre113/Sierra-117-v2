package sierra.dao;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.EntityManager;

public interface IGenericDAO {
	
	public EntityManager getEntityManager();
	public <T extends Serializable> List<T> findAll(final Class<T> clazz);
	public <T extends Serializable> T  create(final T entity);
	public <K, T extends Serializable> T findById(final Class<T> clazz, final K id);
	public Serializable update(final Serializable entity);
	public void delete(final Serializable entity);
}
