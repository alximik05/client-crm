package ru.iemz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.iemz.dao.ClientRepository;
import ru.iemz.domains.Client;
import ru.iemz.service.ClientService;

import java.util.List;

/**
 * Created by stas on 04/03/17.
 */
@Controller
@RequestMapping("/clients")
public class ClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @GetMapping
    public String getAllClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("text", "message text from controller");
        return "clientsList";
    }


}
