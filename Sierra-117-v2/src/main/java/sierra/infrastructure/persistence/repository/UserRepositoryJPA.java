/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version  21:59:12 - 09/04/2024
 *
 */
package sierra.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sierra.infrastructure.persistence.entity.User;

/**
 * 
 */
public interface UserRepositoryJPA extends JpaRepository<User, String>  {

}
