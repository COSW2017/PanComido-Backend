package edu.eci.cosw.pancomido.repositories;

import edu.eci.cosw.pancomido.model.Dish;
import edu.eci.cosw.pancomido.model.Restaurant;
import edu.eci.cosw.pancomido.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Query("SELECT d FROM Dish as d WHERE d.restaurant.id_restaurant = ?1")
    public List<Dish> getDishesByRestaurant(Integer idRestaurant);
}
