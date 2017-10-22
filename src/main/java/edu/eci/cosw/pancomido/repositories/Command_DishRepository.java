package edu.eci.cosw.pancomido.repositories;

import edu.eci.cosw.pancomido.model.Command;
import edu.eci.cosw.pancomido.model.Command_Dish;
import edu.eci.cosw.pancomido.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Command_DishRepository extends JpaRepository<Command_Dish, Integer> {

    @Query("select c from Command_Dish as c where c.id_command = :id_command AND c.id_dish = :id_dish")
    Command_Dish getCommandDish(@Param("id_command") Command id_command,
                                @Param("id_dish") Dish id_dish);
}
