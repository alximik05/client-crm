package ru.iemz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.iemz.dao.OrderRepository;
import ru.iemz.domains.Order;

import java.util.List;

/**
 * Created by stas on 08/03/17.
 */
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @ResponseBody
    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
