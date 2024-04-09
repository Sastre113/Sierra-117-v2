/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version  21:41:56 - 09/04/2024
 *
 */
package sierra.infrastructure.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import sierra.domain.model.UserED;
import sierra.domain.repository.UserRepositoryDomain;
import sierra.infrastructure.persistence.entity.User;

/**
 * 
 */
@Repository
public class UserRepository implements UserRepositoryDomain {

	private final UserRepositoryJPA userRepositoryJPA;
	
	public UserRepository(UserRepositoryJPA userRepositoryJPA) {
		this.userRepositoryJPA = userRepositoryJPA;
	}

	@Override
	public UserED save(UserED user) {
		// TODO Auto-generated method stub
		
		User userEntity = new User();
		userEntity.setIdUser(null);
		
		
		
		this.userRepositoryJPA.save(userEntity);
		
		return user;
	}

	@Override
	public Optional<UserED> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void delete(UserED user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserED> findAll() {
		// TODO Auto-generated method stub
		return null;
	}	
}