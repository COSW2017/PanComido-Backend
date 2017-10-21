package edu.eci.cosw.pancomido.controller;


import edu.eci.cosw.pancomido.model.Command_Dish;
import edu.eci.cosw.pancomido.service.Command_DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;

@RestController
@RequestMapping("commandDish")
public class Command_DishController {

    @Autowired
    Command_DishService commandD;

    @RequestMapping( value = "/commands/{id_command}/{id_dish}")
    public Command_Dish addDishC(@PathVariable Integer id_command, @PathVariable Integer id_dish)
            throws ServletException
    {
        return commandD.addDishCommand(id_command, id_dish);
    }

    @RequestMapping( value = "/commands/{id_command}/{id_dish}")
    public  Boolean deleteDishC(@PathVariable Integer id_command, @PathVariable Integer id_dish)
            throws ServletException
    {
        boolean del = commandD.deleteDishCommand(id_command, id_dish);
        if (!del){
            throw new ServletException("Cannot delete dish. ");
        }

        return del;
    }
}
