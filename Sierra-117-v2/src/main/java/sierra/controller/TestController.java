/**
 * 
 */
package sierra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * 
 */
@RestController
public class TestController {
	
	@PersistenceContext
	private EntityManager entityManager;

	public TestController(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	
	@GetMapping(path = "/test")
	public ResponseEntity<Void> testMethod(){
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
