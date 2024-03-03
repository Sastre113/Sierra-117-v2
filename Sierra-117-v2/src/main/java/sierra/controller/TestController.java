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
import sierra.model.entity.TestTable;

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
		TestTable test = this.entityManager.find(TestTable.class, "237bd71b-b053-48f7-9d45-4799f28089c8");
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
