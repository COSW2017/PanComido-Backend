package edu.eci.cosw.pancomido.controller;

import edu.eci.cosw.pancomido.model.Dish;
import edu.eci.cosw.pancomido.model.Order;
import edu.eci.cosw.pancomido.model.Restaurant;
import edu.eci.cosw.pancomido.model.Todo;
import edu.eci.cosw.pancomido.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.List;

/**
 * Created by NGS on 9/12/17.
 */

@RestController
@RequestMapping( "restaurant" )
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @RequestMapping( value = "/{id_restaurant}/order", method = RequestMethod.GET )
    public List<Order> getOrders(@PathVariable Integer id_restaurant)
            throws ServletException
    {
        return restaurantService.getOrders(id_restaurant);

    }

    @RequestMapping( value = "/{id_restaurant}/dish", method = RequestMethod.POST )
    public Dish addDish(@PathVariable Integer id_restaurant, @RequestBody Dish d)
            throws ServletException
    {
        return restaurantService.addDish(id_restaurant, d);
    }

    @RequestMapping( value = "/{id_restaurant}/dish", method = RequestMethod.PUT )
    public Dish modifyDish(@PathVariable Integer id_restaurant, @RequestBody Dish d)
            throws ServletException
    {
        return restaurantService.modifyDish(id_restaurant, d);
    }

    @RequestMapping( value = "/{id_restaurant}/dish", method = RequestMethod.DELETE )
    public boolean deleteDish(@PathVariable Integer id_restaurant, @RequestBody Dish d)
            throws ServletException
    {
        return restaurantService.deleteDish(id_restaurant, d);
    }

    @RequestMapping( value = "/order", method = RequestMethod.POST )
    public Boolean addDish(@RequestBody Integer id_restaurant, Integer id__order, Integer state )
            throws ServletException
    {
        return restaurantService.changeStateOrder(id_restaurant, id__order, state);

    }

    @RequestMapping( value = "/near/{latitude}/{longitude}", method = RequestMethod.GET )
    public List<Restaurant> getNearRestaurants(@PathVariable Double latitude, @PathVariable Double longitude)
            throws ServletException{
        return restaurantService.getLocationRestaurants(latitude, longitude);

    }

    @RequestMapping( value = "{id_restaurant}/dish", method = RequestMethod.GET )
    public List<Dish> getDishesByRestaurant(@PathVariable Integer idRestaurant)
            throws ServletException{
        return restaurantService.getDishes(idRestaurant);
    }


    @RequestMapping( value = "/register", method = RequestMethod.GET )
    public Restaurant restaurantRegister(@RequestBody Restaurant toRegister)
            throws ServletException{
        return restaurantService.addRestaurant(toRegister);

    }

    @RequestMapping( value = "/{id_restaurant}/order/{id_order}", method = RequestMethod.GET )
    public Order getOrdersById(@PathVariable Integer id_restaurant,@PathVariable Integer id_order)
            throws ServletException
    {
        return restaurantService.getOrdersById(id_restaurant, id_order);

    }

}
