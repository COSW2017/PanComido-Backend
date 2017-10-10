package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.Exceptions.PanComidoServicesException;
import edu.eci.cosw.pancomido.model.*;

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

    Order getOrder(Integer id_order);

    PaymentMethod addPaymentMethod(Integer idUser, PaymentMethod paymentMethod);

    /*
    Estado: 0 -> En cola, 1-> Progreso, 2->Lista, -1->Cancelada
     */
    Order cancelOrder(Order order) throws PanComidoServicesException;

    Order getOrderById(Integer id_order);

}