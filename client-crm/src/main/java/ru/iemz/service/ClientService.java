package ru.iemz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.iemz.controller.OrderController;
import ru.iemz.dao.ClientRepository;
import ru.iemz.domains.Client;

import java.util.List;
import java.util.Objects;

/**
 * Created by stas on 19/03/17.
 */
@Service
public class ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        List<Client> all = clientRepository.findAll();
        LOGGER.debug("client list size = {}", all.size());
        return all;
    }

    public Client getClientById(Long id) {
        Client client = clientRepository.getOne(id);
        LOGGER.debug("client by id = {}", client.getId());
        return Objects.requireNonNull(client, "Client not found");
    }
}
