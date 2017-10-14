package edu.eci.cosw.pancomido.repositories;

import edu.eci.cosw.pancomido.model.Command;
import edu.eci.cosw.pancomido.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommandRepository extends JpaRepository<Command, Integer> {

    @Query("SELECT c FROM Command as c WHERE c.id_order = ?1")
    public List<Command> getCommandsByOrder(Integer orderId);

    //No sé si este bien supongo que no...
    @Query("select cd.id_command from Command_Dish as cd inner join cd.id_dish as d where d.restaurant.id_restaurant = ?1")
    public List<Command> getCommandByRestaurant(Integer restaurantId);

    //Falta probar
    @Query("select c from Command as c where c.id_command = ?1")
    public Command getCommand(Integer CommandId);

    @Query("select cd.id_dish from Command_Dish as cd where cd.id_command.id_command = ?1")
    public List<Dish> getDishesByCommand(Integer CommandId);


}
