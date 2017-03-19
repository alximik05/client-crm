package ru.iemz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by stas on 09/03/17.
 */
@Controller
public class MainController {

    @GetMapping
    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
