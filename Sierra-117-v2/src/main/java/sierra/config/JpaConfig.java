/**
 * 
 */
package sierra.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:secrets.properties")
@PropertySource("classpath:application.yml")
public class JpaConfig {

	@Value("${DB_HOST}")
	private String dbHost;
	@Value("${DB_PORT}")
	private String dbPort;
	@Value("${DB_NAME}")
	private String dbName;
	@Value("${DB_USER}")
	private String dbUser;
	@Value("${DB_PASSWORD}")
	private String dbPassword;
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setPersistenceUnitName("sierra117EntityManagerFactory");
		entityManagerFactory.setDataSource(dataSource);
		entityManagerFactory.setPackagesToScan("sierra.model.entity");

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactory.setJpaProperties(this.getProperties());

		return entityManagerFactory;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl(String.format("jdbc:postgresql://%s:%s/%s", dbHost, dbPort, dbName));
		dataSource.setUsername(dbUser);
		dataSource.setPassword(dbPassword);

		return dataSource;
	}

	private Properties getProperties() {
		Properties properties = new Properties();
		properties.setProperty("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.setProperty("spring.jpa.properties.hibernate.jdbc.time_zone", "UTC");
		properties.setProperty("spring.jpa.show-sql", "true");
		properties.setProperty("hibernate.default_schema", "sierra_schema");

		return properties;
	}
}