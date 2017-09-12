package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.model.Dish;
import edu.eci.cosw.pancomido.model.Order;
import edu.eci.cosw.pancomido.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by NGS on 9/12/17.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService{

    HashMap<Integer,Restaurant> restaurants = new HashMap<>();

    @Autowired
    public RestaurantServiceImpl()
    {

    }

    @Override
    public Dish addDish(Restaurant r, Dish d) {
        return null;
    }

    @Override
    public Dish deleteDish(Restaurant r, Dish d) {
        return null;
    }

    @Override
    public Dish modifyDish(Restaurant r, Dish d) {
        return null;
    }

    @Override
    public List<Order> getOrders(Integer id_restaurant) {
        return restaurants.get(id_restaurant).getOrders();
    }

    //Tal vez se debería crear un orderController
    @Override
    public Boolean changeStateOrder(Integer id_restaurant, Integer id_order, Integer state) {
        List<Order> orders = restaurants.get(id_restaurant).getOrders();
        Boolean found = false;
        for (int i = 0; i < orders.size() & !found; i++){
            if(orders.get(i).getId() == id_order){
                orders.get(i).setState(state);
                found = true;
            }
        }
        return found;
    }

    public HashMap<Integer, Restaurant> getRestaurantes() {
        return restaurants;
    }

    public void setRestaurantes(HashMap<Integer, Restaurant> restaurantes) {
        this.restaurants = restaurantes;
    }
}
