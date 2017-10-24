package edu.eci.cosw.pancomido.repositories;

import edu.eci.cosw.pancomido.model.Dish;
import edu.eci.cosw.pancomido.model.Command;
import edu.eci.cosw.pancomido.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("select cd.id_command.id_order from Command_Dish as cd inner join cd.id_dish as d where d.restaurant.id_restaurant = ?1 GROUP BY cd.id_command.id_command")
    public List<Order> getRestaurantOrders(Integer idRestaurant);

    @Query("SELECT o FROM Order as o WHERE o.user_id.user_id = ?1")
    public List<Order> getOrdersByUser(Integer userId);


}
