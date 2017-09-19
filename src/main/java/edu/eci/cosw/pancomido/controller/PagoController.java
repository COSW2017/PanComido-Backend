package edu.eci.cosw.pancomido.controller;


import edu.eci.cosw.pancomido.model.MetodoPago;
import edu.eci.cosw.pancomido.model.Order;
import edu.eci.cosw.pancomido.service.PagoService;
import edu.eci.cosw.pancomido.service.PagoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;

@RestController
@RequestMapping( "payment" )
public class PagoController {

    @Autowired
    PagoService pagoService;

    @RequestMapping( value = "/", method = RequestMethod.POST )
    public Boolean payOrder(@RequestBody Order orden, MetodoPago metodoPago, int identificador)
            throws ServletException {
        return pagoService.pagarOrden(orden, metodoPago, identificador);

    }

}
