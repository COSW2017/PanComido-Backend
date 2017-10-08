package edu.eci.cosw.pancomido.repositories;

import edu.eci.cosw.pancomido.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
