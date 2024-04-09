/**
 * 
 */
package sierra.domain.use_case;

import sierra.domain.model.UserED;

/**
 * 
 */
public interface UserUseCase {

	public UserED create(UserED user);
	public UserED findById(String idUser);
	public UserED update(UserED user);
	public void delete(String idUser);
	
}
