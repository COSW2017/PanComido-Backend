package edu.eci.cosw.pancomido.repositories;

import edu.eci.cosw.pancomido.model.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommandRepository extends JpaRepository<Command, Integer> {

    @Query("SELECT c FROM Command as c WHERE c.id_order = ?1")
    public List<Command> getCommandsByOrder(Integer orderId);

    //No sé si este bien supongo que no...
    @Query("select c from Command as c inner join Dish as d inner join d.restaurant as r where r.id_restaurant = ?1")
    public List<Command> getCommandByRestaurant(Integer restaurantId);

    //Falta probar
    @Query("select c from Command as c where c.id_command = ?1")
    public Command getCommand(Integer CommandId);
}
