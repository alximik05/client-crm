package ru.iemz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iemz.domains.Order;

/**
 * Created by stas on 04/03/17.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
