package edu.eci.cosw.pancomido.repositories;

import edu.eci.cosw.pancomido.model.Command;
import edu.eci.cosw.pancomido.model.Dish;
import edu.eci.cosw.pancomido.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Integer> {

    @Query("SELECT f FROM Friend as f WHERE (f.user_id.user_id = ?1 AND f.friend_id.user_id = ?2) OR (f.user_id.user_id = ?2 AND f.friend_id.user_id = ?1)")
    public Friend checkIfAFriendshipExist(Integer userId, Integer friendId);

    @Query("SELECT f FROM Friend as f WHERE (f.user_id.user_id = ?1 AND f.friend_id.user_id = ?2) OR (f.user_id.user_id = ?2 AND f.friend_id.user_id = ?1) AND f.state = 0")
    public Friend checkIfAPendingFriendshipExist(Integer userId, Integer friendId);


}
