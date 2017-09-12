package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.model.Order;
import edu.eci.cosw.pancomido.model.User;

import java.util.HashMap;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
public interface UserService
{
    HashMap<Long, User> getUsers();

    User getUser( Long id );

    User createUser( User user );

    User findUserByEmail( String email );

    User findUserByEmailAndPassword( String email, String password );

    User updateUser(User user);

    Boolean addFriend(Long user, Long friend);

    Order getOrder(Long id_user, Integer id_order);
}