package sierra.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T extends Serializable> {
	
	public List<T> findAll(final T clazz);
	public T create(final T entity);
	public <K> T findById(final Class<T> clazz, final K id);
	public T update(final T entity);
	public void delete(final T entity);
	
}
