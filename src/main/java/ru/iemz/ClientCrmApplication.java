package ru.iemz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.iemz.dao.ClientRepository;
import ru.iemz.domains.Client;

@SpringBootApplication
public class ClientCrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientCrmApplication.class, args);
	}

	@Bean
	public CommandLineRunner test(ClientRepository clientRepository) {
		return (args) -> {
			Client client = new Client();
			client.setName("Восген");
			clientRepository.save(client);
		};

	}
}
