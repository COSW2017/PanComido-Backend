package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.model.Order;
import edu.eci.cosw.pancomido.model.Command;

import java.util.List;

public interface OrderService {

    /*
    Estado: 0 ->
     */
    //Boolean changeCommandState(Integer id_order, Integer id_pedido, Integer state);

    Order getOrderById(Integer id_order);

    List<Command> getPedidosByRestaurant(Integer id_restaurant);

}