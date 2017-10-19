package edu.eci.cosw.pancomido.service;

import com.sun.org.apache.xpath.internal.operations.Or;
import edu.eci.cosw.pancomido.model.*;
import edu.eci.cosw.pancomido.repositories.CommandRepository;
import edu.eci.cosw.pancomido.repositories.DishRepository;
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




    /*public Dish modifyDish(Integer id_restaurant, Dish d) {
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
    }*/




    @Override
    public Dish modifyDish(Integer id_restaurant, Dish d) {

        Dish dish = dishRepository.getOne(d.getId_dish());
        dish.setName(d.getName());
        dish.setPrice(d.getPrice());
        dish.setPrep_time(d.getPrep_time());
        dish.setDescription(d.getDescription());

        return dishRepository.save(dish);
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

    public List<Restaurant> getLocationRestaurants(Float latitude, Float longitude){
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
        return restaurantRepository.getDishesByRestaurant(idRestaurant);
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.saveAndFlush(restaurant);
    }

    @Override
    public Command changeCommandState(Command command) {
        Command updateCommand = commandRepository.getOne(command.getId_command());
        updateCommand.setState(command.getState());
        commandRepository.saveAndFlush(updateCommand);
        return command;
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
    private Float calculateDistance(Float latitude1, Float latitude2, Float longitude1, Float longitude2) {
        Double rad =Math.PI/180;
        Float dlat=latitude2-latitude1;
        Float dlon=longitude2-longitude1;
        Double a = Math.pow(Math.sin(rad*dlat/2), 2)+Math.cos(rad*latitude1)*
                Math.cos(rad*latitude2)*Math.pow(Math.sin(rad*dlon/2), 2);
        Float distance = Float.parseFloat(2*RADIUS*Math.asin(Math.sqrt(a))+"");
        return distance;
    }





}
