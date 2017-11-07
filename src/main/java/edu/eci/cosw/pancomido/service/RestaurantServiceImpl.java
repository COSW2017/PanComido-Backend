package edu.eci.cosw.pancomido.service;

import com.sun.org.apache.xpath.internal.operations.Or;
import edu.eci.cosw.pancomido.model.*;
import edu.eci.cosw.pancomido.repositories.CommandRepository;
import edu.eci.cosw.pancomido.repositories.DishRepository;
import edu.eci.cosw.pancomido.repositories.OrderRepository;
import edu.eci.cosw.pancomido.repositories.RestaurantRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
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
    public DishRepository dishRepository;

    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    public RestaurantServiceImpl() { }


    @Override
    public Dish addDish(Dish d) {
        return dishRepository.saveAndFlush(d);
    }

    @Override
    public Boolean deleteDish(Integer id_dish) {
        Dish dish = dishRepository.getOne(id_dish);
        Integer activeCommands = commandRepository.checkActiveCommandsByDishId(dish.getId_dish()).size();
        boolean found = activeCommands == 0;
        if (found) {
            dishRepository.delete(dish);
        }
        return found;
    }

    @Override
    public Dish modifyDish(Integer id_restaurant, Dish d) {

        Dish dish = dishRepository.getOne(d.getId_dish());
        dish.setName(d.getName());
        dish.setPrice(d.getPrice());
        dish.setPrep_time(d.getPrep_time());
        dish.setDescription(d.getDescription());
        dish.setImage(d.getImage());
        return dishRepository.save(dish);
    }

    public HashMap<Integer, Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(HashMap<Integer, Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Restaurant> getLocationRestaurants(Float latitude, Float longitude){
        List<Restaurant> restaurants = restaurantRepository.findAll();
        ArrayList<Restaurant> locationRestaurants = new ArrayList<>();
        for(Restaurant restaurant : restaurants){
            if(calculateDistance(latitude, restaurant.getLatitude(), longitude, restaurant.getLongitude()) < 0.5){
                locationRestaurants.add(restaurant);
            }
        }
        return locationRestaurants;
    }

    @Override
    public List<Dish> getDishes(Integer idRestaurant) {
        //return restaurants.get(idRestaurant).getDishes();
        return restaurantRepository.getDishesByRestaurant(idRestaurant);
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.saveAndFlush(restaurant);
    }

    @Override
    public Restaurant getRestByName(String name) {
        List<Restaurant> rests = restaurantRepository.findAll();
        boolean fd = false;
        Restaurant rt = new Restaurant();
        for (int i = 0; i < rests.size() && !fd; i++) {
            if (name.equalsIgnoreCase(rests.get(i).getName())){
                rt = rests.get(i);
                fd = true;
            }
        }
        return rt;
    }

    @Override
    public Command changeCommandState(Command command) {
        System.out.print("Entra aquí");
        Command updateCommand = commandRepository.getOne(command.getId_command());
        updateCommand.setState(command.getState());
        commandRepository.saveAndFlush(updateCommand);
        return command;
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        Restaurant updateRestaurant = restaurantRepository.getOne(restaurant.getId_restaurant());
        updateRestaurant.setName(restaurant.getName());
        updateRestaurant.setLatitude(restaurant.getLatitude());
        updateRestaurant.setLongitude(restaurant.getLongitude());
        updateRestaurant.setImage(restaurant.getImage());
        restaurantRepository.saveAndFlush(updateRestaurant);
        return restaurant;
    }

    @Override
    public List<Order> getRestaurantOrders(int id_restaurant) {
        return orderRepository.getRestaurantOrders(id_restaurant);
    }

    @Override
    public Command addCommand(Command command) {
        return commandRepository.saveAndFlush(command);
    }


    @Override
    public Command getCommand(Integer id_Command) {
        return commandRepository.getCommand(id_Command);
    }

    // Revisar porque muy posiblemente no funcione la QUERY
    @Override
    public List<Command> getCommands(Integer idRestaurant) {
        return commandRepository.getCommandByRestaurant(idRestaurant);
    }

    @Override
    public Restaurant getOwner(Integer user_id) {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        boolean find = false;
        Restaurant restaurant = null;
        for(int i = 0; i < restaurants.size() && !find; i++){
            if(restaurants.get(i).getUser_id().getUser_id() == user_id){
                restaurant = restaurants.get(i);
                find = true;
            }
        }
        return restaurant;
    }
    /*
    Lista los platos por pedido
     */
    @Override
    public List<Dish> getDishByCommandId(Integer id_command) {
        return commandRepository.getDishes(id_command);
    }

    @Override
    public Dish getDishByDishId(Integer idRestaurant, Integer dish_id) {
        //Esta cosa no sirvió y ni idea por qué
        //System.out.println(dishRepository.getOne(dish_id));
        //return dishRepository.getOne(dish_id);
        List<Dish> dishes = this.getDishes(idRestaurant);
        Dish dish = null;
        for (Dish d: dishes) {
            if (d.getId_dish()==dish_id){
                dish = d;
                break;
            }
        }
        return dish;
    }

    /**
     * Calcula la distancia entre dos restaurantes
     * @param latitude1
     * @param latitude2
     * @param longitude1
     * @param longitude2
     * @return
     */
    private Double calculateDistance(Float latitude1, Float latitude2, Float longitude1, Float longitude2) {
        double theta = longitude1 - longitude2;
        System.out.println("long "+longitude1+" long "+longitude2);
        double dist = Math.sin(deg2rad(latitude1)) * Math.sin(deg2rad(latitude2)) + Math.cos(deg2rad(latitude1)) * Math.cos(deg2rad(latitude2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        System.out.println(dist+" "+latitude1+" "+longitude1);
        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }





}
