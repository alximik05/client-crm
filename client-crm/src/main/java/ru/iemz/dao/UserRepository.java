package ru.iemz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.iemz.domains.User;

/**
 * Created by stas on 04/03/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
