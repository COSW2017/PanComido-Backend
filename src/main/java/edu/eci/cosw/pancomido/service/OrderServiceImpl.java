package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.model.Order;
import edu.eci.cosw.pancomido.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author juanfg7
 * 1/10/17.
 */
@Service
public class OrderServiceImpl implements OrderService{

    public HashMap<Integer, Restaurant> restaurants = new HashMap<>();

    @Autowired
    public OrderServiceImpl() {

    }

    @Override
    public Boolean changeStateOrder(Integer id_restaurant, Integer id_order, Integer state) {
        List<Order> orders = restaurants.get(id_restaurant).getOrders();
        Boolean found = false;
        for(int i = 0; i < orders.size() && !found; i++) {
            if(orders.get(i).getId() == id_order){
                orders.get(i).setState(state);
                found = true;
            }
        }
        return found;
    }
}
