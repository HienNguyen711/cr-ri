package project.userservice;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.validation.Valid;

@SpringBootApplication
public class UserserviceApplication {






	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}
}
