package edu.eci.cosw.pancomido.repositories;

import edu.eci.cosw.pancomido.model.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommandRepository extends JpaRepository<Command, Integer> {

    @Query("SELECT c command FROM Command as c WHERE c.id_order = ?1")
    public List<Command> getCommandsByOrder(Integer orderId);
}
