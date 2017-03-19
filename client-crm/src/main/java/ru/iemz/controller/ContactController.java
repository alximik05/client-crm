package ru.iemz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.iemz.dao.ContactRepository;
import ru.iemz.domains.Contact;
import ru.iemz.service.ContactService;

import java.util.List;

/**
 * Created by stas on 08/03/17.
 */
@Controller
@RequestMapping("/contacts")
public class ContactController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);

    private ContactService contactService;

    @GetMapping
    public String getAllContacts(Model model) {
        model.addAttribute("clients", contactService.getAllContacts());
        return "clientsList";
    }
}
