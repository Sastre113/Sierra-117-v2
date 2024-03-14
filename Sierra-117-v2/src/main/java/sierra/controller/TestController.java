/**
 * 
 */
package sierra.controller;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sierra.dao.GenericDao;
import sierra.model.entity.User;

/**
 * 
 */
@RestController
public class TestController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private GenericDao<Serializable> genericDao;

	public TestController(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	@GetMapping(path = "/test")
	public ResponseEntity<Void> testMethod(){
		User user = new User();
		user.setIdUser(UUID.randomUUID().toString());
		user.setUserName("userName");
		user.setFirstName("firstName");
		user.setActive(Boolean.FALSE);
		user.setEmail("fake");
		
		this.genericDao.create(user);
		
		//this.genericDao.findById(User.class, user.getIdUser());
		
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
