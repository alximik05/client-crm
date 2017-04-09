package ru.iemz.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ru.iemz.dao.ContactRepository;
import ru.iemz.domains.Contact;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by stas on 02/04/17.
 */
@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class ContactServiceTestMock {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactService contactService;



    @Test
    public void getAllContacts() throws Exception {
//        given(contactRepository.findAll()).willReturn(Collections.EMPTY_LIST);
        when(contactRepository.findAll()).thenReturn(Collections.emptyList());
        List<Contact> allContacts = contactService.getAllContacts();
        verify(contactRepository).findAll();
    }


}