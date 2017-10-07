package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.Exceptions.PanComidoServicesException;
import edu.eci.cosw.pancomido.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;


@Service
public class PagoServiceImpl implements PagoService{

    private HashMap<Integer, Payment> pagos = new HashMap<>();

    public boolean payCommand(Command command, User user, int identificador) throws PanComidoServicesException {
        Double monto = command.getMonto();
        boolean orderPaid = true; Payment p = null; Command c;
        PaymentMethod paymentMethod = user.getPaymentMethod();
        if(paymentMethod!=null) {
            orderPaid= paymentMethod.isValid();
            if(orderPaid){
                p =new Payment(user, command);
            }
        }else {
            throw new PanComidoServicesException(PanComidoServicesException.NO_METODO_DE_PAGO + user.getFirstname());
        }
        orderPaid = orderPaid && PaymentGateway.pagar(p, identificador);
        if (orderPaid){
            command.setState(2);
        }
        return orderPaid;
    }

}
