package edu.eci.cosw.pancomido.controller;


import edu.eci.cosw.pancomido.model.Command;
import edu.eci.cosw.pancomido.model.User;
import edu.eci.cosw.pancomido.service.PagoService;
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
    PagoService pagoService;

    @RequestMapping( value = "/pay", method = RequestMethod.POST )
    public Boolean payOrder(@RequestBody Command command, @RequestBody User user, @RequestBody int identificador)
            throws ServletException, PanComidoServicesException {
        return pagoService.payCommand(command, user, identificador);

    }

}
