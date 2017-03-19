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
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;


    @GetMapping
    public String getAllClients(Model model) {
        model.addAttribute("clients", clientRepository.findAll());
        return "clientsList";
    }


}
