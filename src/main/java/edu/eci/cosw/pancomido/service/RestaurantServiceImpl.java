package edu.eci.cosw.pancomido.service;

import com.sun.org.apache.xpath.internal.operations.Or;
import edu.eci.cosw.pancomido.model.Dish;
import edu.eci.cosw.pancomido.model.Order;
import edu.eci.cosw.pancomido.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by NGS on 9/12/17.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService{


    public HashMap<Integer, Restaurant> restaurants = new HashMap<>();
    private final Double RADIUS = 6371.0;

    @Autowired
    public RestaurantServiceImpl() {
    }

    @Override
    public Dish addDish(Integer id_restaurant, Dish d) {
        Restaurant r = restaurants.get(id_restaurant);
        List<Dish> dishes = r.getDishes();
        dishes.add(d);
        return d;
    }

    @Override
    public Boolean deleteDish(Integer id_restaurant, Integer id_dish) {
        boolean found = false;
        Restaurant r = restaurants.get(id_restaurant);

        List<Dish> dishes = r.getDishes();
        List<Order> orders = r.getOrders();
        boolean found2 = false;
        for (int i = 0 ; i < dishes.size() && !found; i++){

            if(dishes.get(i).getId() == id_dish){
                found2 = false;
                for (int j = 0 ; j < orders.size() && !found2; j++){
                    if(orders.get(j).getId() == dishes.get(i).getId()){
                        found2 = true;
                    }
                }
                if(!found2){
                    dishes.remove(i);
                }
                found = true;
            }
        }
        return found && !found2;
    }

    @Override
    public Dish modifyDish(Integer id_restaurant, Dish d) {
        boolean found = false;
        Restaurant r = restaurants.get(id_restaurant);
        List<Dish> dishes = r.getDishes();
        for (int i = 0 ; i < dishes.size() && !found; i++){
            if(dishes.get(i).equals(d)){
                dishes.set(i, d);
                found = true;
            }
        }
        return d;
    }


    @Override
    public List<Order> getOrders(Integer id_restaurant) {
        return restaurants.get(id_restaurant).getOrders();
    }

    public HashMap<Integer, Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(HashMap<Integer, Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Restaurant> getLocationRestaurants(Double latitude, Double longitude){
        ArrayList<Restaurant> locationRestaurants = new ArrayList<>();
        Restaurant r = null; 
        for(Integer i : restaurants.keySet()){
            r = restaurants.get(i);
            if(calculateDistance(latitude, r.getLatitude(), longitude, r.getLongitude()) < 0.2){
                locationRestaurants.add(r);
            }
        }
        return locationRestaurants;
    }

    @Override
    public List<Dish> getDishes(Integer idRestaurant) {
        return restaurants.get(idRestaurant).getDishes();
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getId_restaurant(), restaurant);
        return restaurant;
    }

    @Override
    public Order getOrdersById(Integer id_restaurant, Integer id_order) {
        List<Order> orders = restaurants.get(id_restaurant).getOrders();
        Order ord = null;
        for (Order o: orders) {
            if (o.getId()== id_order){
                ord = o;
                break;
            }
        }
        return ord;
    }

    private Double calculateDistance(Double latitude1, Double latitude2, Double longitude1, Double longitude2) {
        Double rad =Math.PI/180;
        Double dlat=latitude2-latitude1;
        Double dlon=longitude2-longitude1;
        Double a = Math.pow(Math.sin(rad*dlat/2), 2)+Math.cos(rad*latitude1)*
                Math.cos(rad*latitude2)*Math.pow(Math.sin(rad*dlon/2), 2);
        Double distance = 2*RADIUS*Math.asin(Math.sqrt(a));
        return distance;
    }


}
