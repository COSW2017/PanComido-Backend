package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.model.*;

import java.util.HashMap;

import edu.eci.cosw.pancomido.exceptions.PanComidoServicesException;
import edu.eci.cosw.pancomido.model.*;

import java.util.List;


/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
public interface UserService
{
    List<User> getUsers();

    User getUser(Integer id);

    User createUser(User user );

    User findUserByEmail( String email );

    User findUserByEmailAndPassword( String email, String password );

    User updateUser(User user);

    Boolean addFriend(Integer user, Integer friend);

    Order getOrder(Integer id_order);

    PaymentMethod addPaymentMethod(Integer idUser, PaymentMethod paymentMethod);

    /*
    Estado: 0 -> En cola, 1-> Progreso, 2->Lista, -1->Cancelada
     */
    Order cancelOrder(Order order) throws PanComidoServicesException;

    Order getOrderById(Integer id_order);

    List<Order> getOrders(Integer id_user);

    User modifyUserData(String email, String user_pas, String city, String cellphone);

}