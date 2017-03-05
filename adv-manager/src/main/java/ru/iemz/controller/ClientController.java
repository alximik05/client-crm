package ru.iemz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.iemz.dao.ClientRepository;
import ru.iemz.domains.Client;

import java.util.List;

/**
 * Created by stas on 04/03/17.
 */
@Controller
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @RequestMapping(name = "/clients")
    @ResponseBody
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
