package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.model.*;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

/**
 * Created by 2100038 on 9/12/17.
 */
public interface RestaurantService {

    Dish addDish(Integer id_restaurant, Dish d);

    Boolean deleteDish(Integer id_restaurant, Integer id_dish);

    Dish modifyDish(Integer id_restaurant, Dish d);

    HashMap<Integer, Restaurant> getRestaurants();

    List<Restaurant> getLocationRestaurants(Float latitude, Float longitude);

    List <Dish> getDishes(Integer idRestaurant);

    Restaurant addRestaurant(Restaurant restaurant);

    Command changeCommandState(Command command);

    Command getCommand(Integer id_Command);

    List<Command> getCommands(Integer idRestaurant);

    Restaurant getOwner(Integer user_id);
}
