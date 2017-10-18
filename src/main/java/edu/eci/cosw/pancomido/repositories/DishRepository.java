package edu.eci.cosw.pancomido.repositories;

import edu.eci.cosw.pancomido.model.Command;
import edu.eci.cosw.pancomido.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DishRepository extends JpaRepository <Dish, Integer> {


}
