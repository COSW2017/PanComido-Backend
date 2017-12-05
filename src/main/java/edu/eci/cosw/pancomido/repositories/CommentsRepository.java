package edu.eci.cosw.pancomido.repositories;


import edu.eci.cosw.pancomido.model.Command;
import edu.eci.cosw.pancomido.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Integer> {
    @Query("select c from Comment as c where c.id_restaurant.id_restaurant = ?1")
    List<Comment> getCommentsByRestaurant(Integer restaurantId);
}
