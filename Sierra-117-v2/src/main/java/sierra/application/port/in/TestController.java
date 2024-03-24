/**
 * 
 */
package sierra.application.port.in;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sierra.infrastructure.persistence.dao.IGenericDAO;
import sierra.infrastructure.persistence.entity.User;

/**
 * 
 */
@RestController
public class TestController {

	private IGenericDAO genericDao;

	public TestController(IGenericDAO genericDao) {
		super();
		this.genericDao = genericDao;
	}
	
	@GetMapping(path = "/test")
	@Transactional
	public ResponseEntity<Void> testMethod(){
		User user = new User();
		user.setIdUser(UUID.randomUUID().toString());
		user.setUserName("userName");
		user.setFirstName("firstName");
		user.setActive(Boolean.FALSE);
		user.setEmail("fake");
		user.setCreationDate(new Timestamp(new Date().getTime()));
		
		this.genericDao.create(user);
		User res2 = this.genericDao.findById(User.class, user.getIdUser());
		List<User> res1 = this.genericDao.findAll(User.class);
		
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
