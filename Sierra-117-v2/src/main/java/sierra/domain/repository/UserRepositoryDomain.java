/**
 * 
 */
package sierra.domain.repository;

import java.util.List;
import java.util.Optional;

import sierra.domain.model.UserED;

/**
 * 
 */
public interface UserRepositoryDomain {
	
	UserED save(UserED user);

	Optional<UserED> findById(Long id);

	void delete(UserED user);

	List<UserED> findAll();
}
