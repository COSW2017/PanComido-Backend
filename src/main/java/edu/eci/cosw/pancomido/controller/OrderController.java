package edu.eci.cosw.pancomido.controller;

import edu.eci.cosw.pancomido.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;

/**
 * @author juanfg7
 * 1/10/17.
 */
@RestController
@RequestMapping( "order" )
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Boolean addOrder(@RequestBody Integer id_restaurant, Integer id_order, Integer state)
            throws ServletException {
        return orderService.changeStateOrder(id_restaurant, id_order, state);
    }
}
