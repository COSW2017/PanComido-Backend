package edu.eci.cosw.pancomido.controller;

import edu.eci.cosw.pancomido.model.Dish;
import edu.eci.cosw.pancomido.model.Restaurant;
import edu.eci.cosw.pancomido.model.Todo;
import edu.eci.cosw.pancomido.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;

/**
 * Created by NGS on 9/12/17.
 */

@RestController
@RequestMapping( "restaurant" )
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @RequestMapping( value = "/", method = RequestMethod.POST )
    public Dish addDish(@RequestBody Restaurant r, Dish d )
            throws ServletException
    {
        return restaurantService.addDish(r, d);

    }

    @RequestMapping( value = "/", method = RequestMethod.PUT )
    public Dish modifyDish(@RequestBody Restaurant r, Dish d )
            throws ServletException
    {
        return restaurantService.modifyDish(r, d);

    }

    @RequestMapping( value = "/", method = RequestMethod.PUT )
    public Dish deleteDish(@RequestBody Restaurant r, Dish d )
            throws ServletException
    {
        return restaurantService.deleteDish(r, d);

    }

}
