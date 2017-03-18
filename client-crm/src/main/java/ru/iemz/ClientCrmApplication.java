package ru.iemz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Configuration
//@ComponentScan(basePackages = "ru.iemz.*")
public class ClientCrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientCrmApplication.class, args);
	}
}
