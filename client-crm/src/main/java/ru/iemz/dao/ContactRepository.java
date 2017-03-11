package ru.iemz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.iemz.domains.Client;
import ru.iemz.domains.Contact;

/**
 * Created by stas on 04/03/17.
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
