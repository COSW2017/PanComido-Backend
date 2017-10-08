package edu.eci.cosw.pancomido.service;

import com.sun.org.apache.xpath.internal.operations.Or;
import edu.eci.cosw.pancomido.model.Command;
import edu.eci.cosw.pancomido.model.Dish;
import edu.eci.cosw.pancomido.model.Order;
import edu.eci.cosw.pancomido.model.Restaurant;
import edu.eci.cosw.pancomido.repositories.CommandRepository;
import edu.eci.cosw.pancomido.repositories.RestaurantRepository;
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
    public CommandRepository commandRepository;

    @Autowired
    public RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl() { }


    @Override
    public Dish addDish(Integer id_restaurant, Dish d) {
        /*Restaurant r = restaurants.get(id_restaurant);
        List<Dish> dishes = r.getDishes();
        dishes.add(d);*/
        //restaurants.get(id_restaurant).addDish(d);
        return d;
    }

    @Override
    public Boolean deleteDish(Integer id_restaurant, Integer id_dish) {
        Restaurant restaurant = restaurants.get(id_restaurant);
        Boolean found = false;
        /*if(restaurant.getDishById(id_dish)!=null){
            restaurant.delDishById(id_dish);
            found = true;
        }*/
        return found;
    }

    /*@Override
    public Boolean deleteDish(Integer id_restaurant, Integer id_dish) {
        boolean found = false;
        Restaurant r = restaurants.get(id_restaurant);

        List<Dish> dishes = r.getDishes();
        List<Order> orders = r.getOrders();
        boolean found2 = false;
        for (int i = 0 ; i < dishes.size() && !found; i++){

            if(dishes.get(i).getId_dish() == id_dish){
                found2 = false;
                for (int j = 0 ; j < orders.size() && !found2; j++){
                    if(orders.get(j).getId() == dishes.get(i).getId_dish()){
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
    }*/



    @Override
    public Dish modifyDish(Integer id_restaurant, Dish d) {
        boolean found = false;
        Restaurant r = restaurants.get(id_restaurant);
        List<Dish> dishes = null;
        for (int i = 0 ; i < dishes.size() && !found; i++){
            if(dishes.get(i).equals(d)){
                dishes.set(i, d);
                found = true;
            }
        }
        return d;
    }

    //Tal vez se debería crear un orderController
    /*@Override
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
    }*/


    public HashMap<Integer, Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(HashMap<Integer, Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Restaurant> getLocationRestaurants(Double latitude, Double longitude){
        List<Restaurant> restaurants = restaurantRepository.findAll();
        ArrayList<Restaurant> locationRestaurants = new ArrayList<>();
        for(Restaurant restaurant : restaurants){
            if(calculateDistance(latitude, restaurant.getLatitude(), longitude, restaurant.getLongitude()) < 0.2){
                locationRestaurants.add(restaurant);
            }
        }
        return locationRestaurants;
    }

    @Override
    public List<Dish> getDishes(Integer idRestaurant) {
        //return restaurants.get(idRestaurant).getDishes();
        return null;
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getId_restaurant(), restaurant);
        return restaurant;
    }

    @Override
    public Command changeCommandState(Command command) {
        Command updateCommand = commandRepository.getOne(command.getId_command());
        updateCommand.setState(command.getState());
        commandRepository.saveAndFlush(updateCommand);
        return command;
    }

    @Override
    public List<Command> getCommands(Integer idRestaurant) {
        return null;
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
