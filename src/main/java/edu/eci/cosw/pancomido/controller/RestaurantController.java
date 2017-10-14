package edu.eci.cosw.pancomido.controller;

import edu.eci.cosw.pancomido.Exceptions.PanComidoServicesException;
import edu.eci.cosw.pancomido.model.*;
import edu.eci.cosw.pancomido.service.RestaurantService;
import edu.eci.cosw.pancomido.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by NGS on 9/12/17.
 */

@RestController
@RequestMapping( "restaurant" )
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    UserService userService;

    @RequestMapping( value = "/{id_restaurant}/commands", method = RequestMethod.GET )
    public List<Command> get(@PathVariable Integer id_restaurant)
            throws ServletException {
        return restaurantService.getCommands(id_restaurant);

    }

    @RequestMapping( value = "/commands/{id_command}", method = RequestMethod.GET )
    public Command getCommandById(@PathVariable Integer id_command)
            throws ServletException {
        return restaurantService.getCommand(id_command);

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

    @RequestMapping( value = "/{id_restaurant}/dish/{id_dish}", method = RequestMethod.DELETE )
    public boolean deleteDish(@PathVariable Integer id_restaurant, @PathVariable Integer id_dish)
            throws ServletException
    {
        boolean deleted = restaurantService.deleteDish(id_restaurant, id_dish);
        if(!deleted){
            throw new ServletException("This dish is associated with an active order.");
        }
        return deleted;
    }

    @RequestMapping( value = "/order", method = RequestMethod.POST )
    public Boolean addOrder(@RequestBody Integer id_restaurant, Integer id__order, Integer state )
            throws ServletException {
        return null; 

    }

    @RequestMapping( value = "/near/{latitude}/{longitude}", method = RequestMethod.GET )
    public List<Restaurant> getNearRestaurants(@PathVariable Float latitude, @PathVariable Float longitude)
            throws ServletException{
        return restaurantService.getLocationRestaurants(latitude, longitude);
    }

    @RequestMapping( value = "{idRestaurant}/dish", method = RequestMethod.GET )
    public List<Dish> getDishesByRestaurant(@PathVariable Integer idRestaurant)
            throws ServletException{
        return restaurantService.getDishes(idRestaurant);
    }

    @RequestMapping( value = "/owner/{user_id}", method = RequestMethod.GET )
    public Restaurant getRestaurantOwner(@PathVariable Integer user_id)
            throws ServletException{
        Restaurant restaurant =restaurantService.getOwner(user_id);
        if( restaurant == null){
            throw new ServletException("Restaurante no encontrado");
        }
        return restaurant;
    }


    @RequestMapping( value = "/register", method = RequestMethod.POST )
    public Restaurant restaurantRegister(@RequestBody Restaurant toRegister)
            throws ServletException{
        return restaurantService.addRestaurant(toRegister);
    }

    public List<Command> getCommandsByRestaurant(@RequestBody Integer idRestaurant){
        return restaurantService.getCommands(idRestaurant);
    }

    @RequestMapping( value = "{idRestaurant}/command", method = RequestMethod.PUT )
    public Command updateCommmandState(@PathVariable Integer id_restaurant, @RequestBody Command command)
            throws ServletException{
        return restaurantService.changeCommandState(command);
    }

    @RequestMapping( value = "{idRestaurant}/command/{id_command}", method = RequestMethod.GET )
    public List<Dish> getDishesByCommand(@PathVariable Integer idRestaurant, @PathVariable Integer id_command)
            throws ServletException{
        List<Dish> dishes = restaurantService.getDishesByCommand(id_command);
        if( dishes == null){
            throw new ServletException("No hay platos registrados para el pedido"+id_command);
        }
        return dishes;
    }



}
