package ru.iemz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.iemz.controller.OrderController;
import ru.iemz.dao.OrderRepository;
import ru.iemz.domains.Order;

import java.util.List;

/**
 * Created by stas on 19/03/17.
 */
@Service
public class OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        List<Order> all = orderRepository.findAll();
        LOGGER.debug("order list size = {}", all.size());
        return all;
    }
}
