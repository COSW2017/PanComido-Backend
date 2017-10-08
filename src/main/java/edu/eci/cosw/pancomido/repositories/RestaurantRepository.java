package edu.eci.cosw.pancomido.repositories;

import edu.eci.cosw.pancomido.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
