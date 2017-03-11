package ru.iemz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by stas on 09/03/17.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @ResponseBody
    @GetMapping
    public String hello() {
        return "Hello, братан";
    }
}
