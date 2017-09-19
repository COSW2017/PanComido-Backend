package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.model.Dish;
import edu.eci.cosw.pancomido.model.Order;
import edu.eci.cosw.pancomido.model.Restaurant;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

/**
 * Created by 2100038 on 9/12/17.
 */
public interface RestaurantService {

    Dish addDish(Integer id_restaurant, Dish d);

    Boolean deleteDish(Integer id_restaurant, Dish d);

    Dish modifyDish(Integer id_restaurant, Dish d);


    List<Order> getOrders(Integer id_restaurant);

    Boolean changeStateOrder(Integer id_restaurant, Integer id_order, Integer state);

    HashMap<Integer, Restaurant> getRestaurants();

    List<Restaurant> getLocationRestaurants(Double latitude, Double longitude);

    List <Dish> getDishes(Integer idRestaurant);

    List <Order> getOrders(Integer id);

}
