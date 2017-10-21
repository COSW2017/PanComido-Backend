package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.model.*;
import edu.eci.cosw.pancomido.repositories.CommandRepository;
import edu.eci.cosw.pancomido.repositories.Command_DishRepository;
import edu.eci.cosw.pancomido.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Command_DishServiceImpl implements Command_DishService {

    @Autowired
    public CommandRepository commandRepository;

    @Autowired
    public DishRepository dishRepository;

    @Autowired
    public Command_DishRepository command_dishRepository;

    @Autowired
    public Command_DishServiceImpl(){ }

    @Override
    public Command_Dish getDishCommand(Integer id_command, Integer id_dish) {
        Boolean ext = commandRepository.existsById(id_command);
        Boolean est = dishRepository.existsById(id_dish);
        if (est && ext){
           Command c = commandRepository.getOne(id_command);
           Dish d = dishRepository.getOne(id_dish);
           Command_Dish cd = command_dishRepository.getCommandDish(c, d);
           return cd;
        } else {
            return null;
        }
    }

    @Override
    public Command_Dish addDishCommand(Integer id_command, Integer id_dish) {
        Dish dish = dishRepository.getOne(id_dish);
        Command command = commandRepository.getOne(id_command);
        Command_Dish commandD = new Command_Dish(command, dish);
        return command_dishRepository.saveAndFlush(commandD);
    }

    @Override
    public Boolean deleteDishCommand(Integer id_command, Integer id_dish) {
        Boolean ext = commandRepository.existsById(id_command);
        Boolean est = dishRepository.existsById(id_dish);
        Boolean fl = false;
        if (ext && est) {
            Command c = commandRepository.getOne(id_command);
            Dish d = dishRepository.getOne(id_dish);
            Command_Dish commandD = command_dishRepository.getCommandDish(c, d);
            command_dishRepository.delete(commandD);
            fl = true;
        }
        return fl;
    }
}
