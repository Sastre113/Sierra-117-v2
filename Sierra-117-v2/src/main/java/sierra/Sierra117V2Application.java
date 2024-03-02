package sierra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class Sierra117V2Application {

	public static void main(String[] args) {
		//cargarVariablesEnv();
		SpringApplication.run(Sierra117V2Application.class, args);
	}
	
	
	private static void cargarVariablesEnv() {
		Dotenv dotenv = Dotenv.configure().load();
		System.setProperty("DB_HOST", dotenv.get("DB_HOST"));
		System.setProperty("DB_PORT", dotenv.get("DB_PORT"));
		System.setProperty("DB_NAME", dotenv.get("DB_NAME"));
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
	}

}
