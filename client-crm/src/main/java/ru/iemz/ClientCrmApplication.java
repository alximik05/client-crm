package ru.iemz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientCrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientCrmApplication.class, args);
	}

/*	@Bean
	public CommandLineRunner test(ClientRepository clientRepository) {
		return (args) -> {
			Client client = new Client();
			client.setName("Восген");
			clientRepository.save(client);
		};

	}*/
}
