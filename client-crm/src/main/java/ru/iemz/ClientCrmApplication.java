package ru.iemz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@Configuration
//@ComponentScan(basePackages = "ru.iemz.*")
public class ClientCrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientCrmApplication.class, args);
	}
}
