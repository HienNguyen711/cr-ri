package project.userservice;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;

import javax.validation.Valid;

@SpringBootApplication
@EnableCircuitBreaker
public class UserserviceApplication {

	@Value("${spring.profiles}")
	private static String profiles;


	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);

		System.out.print(profiles);
	}
}
