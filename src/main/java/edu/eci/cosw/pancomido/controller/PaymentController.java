package edu.eci.cosw.pancomido.controller;


import edu.eci.cosw.pancomido.model.MetodoPago;
import edu.eci.cosw.pancomido.model.Order;
import edu.eci.cosw.pancomido.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;

@RestController
@RequestMapping( "payment" )
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @RequestMapping( value = "/", method = RequestMethod.POST )
    public Boolean payOrder(@RequestBody Order orden, MetodoPago metodoPago, int identificador)
            throws ServletException {
        return paymentService.pagarOrden(orden, metodoPago, identificador);

    }

}
