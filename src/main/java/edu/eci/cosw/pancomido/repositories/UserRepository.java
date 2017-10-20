package edu.eci.cosw.pancomido.repositories;

import edu.eci.cosw.pancomido.model.Command;
import edu.eci.cosw.pancomido.model.Order;
import edu.eci.cosw.pancomido.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User as u WHERE u.email = ?1")
    public User findUsersByEmail(String email);

    @Query("SELECT u FROM User as u WHERE u.email = ?1 and u.user_password = ?2")
    public List<User> findUsersByEmailAndPassword(String email, String password);

}
