package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.model.Dish;
import edu.eci.cosw.pancomido.model.Order;
import edu.eci.cosw.pancomido.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2100038 on 9/12/17.
 */
public interface RestaurantService {

    Dish addDish(Restaurant r, Dish d);

    Dish deleteDish(Restaurant r, Dish d);

    Dish modifyDish(Restaurant r, Dish d);

    List<Order> getOrders(Integer id_restaurant);

    Boolean changeStateOrder(Integer id_restaurant, Integer id_order, Integer state);
}
