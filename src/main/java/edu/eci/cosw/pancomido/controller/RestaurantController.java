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

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Dish addDish(@RequestBody Restaurant r, Dish d)
            throws ServletException {
        return restaurantService.addDish(r, d);

    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Dish modifyDish(@RequestBody Restaurant r, Dish d)
            throws ServletException {
        return restaurantService.modifyDish(r, d);

    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public Dish deleteDish(@RequestBody Restaurant r, Dish d)
            throws ServletException {
        return restaurantService.deleteDish(r, d);

    }

    @RequestMapping( value = "/{id}/order", method = RequestMethod.GET )
    public List<Order> getOrders(@PathVariable Integer id)
            throws ServletException
    {
        return restaurantService.getOrders(id);

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

    @RequestMapping( value = "/dishes/{idRestaurant}", method = RequestMethod.GET )
    public List<Dish> getDishesByRestaurant(@PathVariable Integer idRestaurant)
            throws ServletException{
        return restaurantService.getDishes(idRestaurant);

    }

}
