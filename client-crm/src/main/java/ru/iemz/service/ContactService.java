package ru.iemz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.iemz.controller.OrderController;
import ru.iemz.dao.ContactRepository;
import ru.iemz.domains.Contact;

import java.util.List;

/**
 * Created by stas on 19/03/17.
 */
@Service
public class ContactService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactService.class);

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        List<Contact> all = contactRepository.findAll();
        LOGGER.debug("contact list size = {}", all.size());
        return all;
    }

    public List<Contact> getContactsByClientId(long clientId) {
        List<Contact> contactsByClientId = contactRepository.getContactsByClientId(clientId);
        LOGGER.debug("contact list size = {}", contactsByClientId.size());
        return contactsByClientId;
    }
}
