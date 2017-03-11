package ru.iemz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.iemz.dao.ContactRepository;
import ru.iemz.domains.Contact;

import java.util.List;

/**
 * Created by stas on 08/03/17.
 */
@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;


    @ResponseBody
    @GetMapping
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}
