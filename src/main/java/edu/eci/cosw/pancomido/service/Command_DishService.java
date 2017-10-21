package edu.eci.cosw.pancomido.service;


import edu.eci.cosw.pancomido.model.Command_Dish;

public interface Command_DishService {

    Command_Dish getDishCommand(Integer id_command, Integer id_dish);

    Command_Dish addDishCommand(Integer id_command, Integer id_dish);

    Boolean deleteDishCommand(Integer id_command, Integer id_dish);

}

