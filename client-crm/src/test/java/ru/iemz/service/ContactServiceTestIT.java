package ru.iemz.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ru.iemz.domains.Contact;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by stas on 02/04/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ContactServiceTestIT {

    @Autowired
    ContactService contactService;


    @Test
    public void getAllContacts() throws Exception {
        List<Contact> allContacts = contactService.getAllContacts();
        Assert.assertEquals(3, allContacts.size());
    }

    @Test
    public void getContactsByClientId() throws Exception {
        List<Contact> contactsByClientId = contactService.getContactsByClientId(1L);
        assertThat(contactsByClientId.size(), is(1));
        assertThat(contactsByClientId.get(0).getName(), is("Ванек"));
        assertThat(contactsByClientId.get(0).getPhone(), is("111-11-11"));
    }
}