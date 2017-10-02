package edu.eci.cosw.pancomido.service;

/**
 * @author juanfg7
 * 1/10/17.
 */
public interface OrderService {

    Boolean changeStateOrder(Integer id_restaurant, Integer id_order, Integer state);
}
