package ru.iemz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iemz.domains.Client;

/**
 * Created by stas on 04/03/17.
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
}
