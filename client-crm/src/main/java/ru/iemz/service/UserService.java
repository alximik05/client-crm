package ru.iemz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.iemz.dao.UserRepository;
import ru.iemz.domains.User;

import java.util.List;

/**
 * Created by stas on 19/03/17.
 */
@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> all = userRepository.findAll();
        LOGGER.debug("user list size = {}", all.size());
        return all;
    }
}
