package ru.iemz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.iemz.dao.UserRepository;
import ru.iemz.domains.User;

import java.util.List;

/**
 * Created by stas on 08/03/17.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
