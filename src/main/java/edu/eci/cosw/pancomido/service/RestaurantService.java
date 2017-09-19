package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.model.Dish;
import edu.eci.cosw.pancomido.model.Order;
import edu.eci.cosw.pancomido.model.Restaurant;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 2100038 on 9/12/17.
 */
public interface RestaurantService {

    Dish addDish(Restaurant r, Dish d);

    Dish deleteDish(Restaurant r, Dish d);

    Dish modifyDish(Restaurant r, Dish d);

    HashMap<Integer, Restaurant> getRestaurants();

    List<Restaurant> getLocationRestaurants(Double latitude, Double longitude);

    List <Dish> getDishes(Integer idRestaurant);

    List <Order> getOrders(Integer id);

}
