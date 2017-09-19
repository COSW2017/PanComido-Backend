package edu.eci.cosw.pancomido.service;

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

    private HashMap<Integer, Restaurant> restaurants = new HashMap<>();
    private final Double RADIUS = 6371.0;

    @Autowired
    public RestaurantServiceImpl() {
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
    public List<Order> getOrders(Integer id) {
        return restaurants.get(id).getOrders();
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
