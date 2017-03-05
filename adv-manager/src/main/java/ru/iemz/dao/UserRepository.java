package ru.iemz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iemz.domains.User;

/**
 * Created by stas on 04/03/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
