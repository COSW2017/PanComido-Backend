package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;


@Service
public class PaymentServiceImpl implements PaymentService {

    private HashMap<Integer, Payment> pagos = new HashMap<>();

    public boolean pagarOrden(Order orden, MetodoPago metodoPago, int identificador){
        ArrayList<Payment> pagosRealizados= new ArrayList<>();
        Double monto = orden.getMonto()/orden.getUsers().size();
        boolean orderPaid = true; Payment p; User u;
        for(int i = 0; i<orden.getUsers().size() && orderPaid; i++){
            u = orden.getUsers().get(i);
            orderPaid= orderPaid && metodoPago.isValid();
            if(orderPaid){
                p =new Payment(u, monto, orden); pagosRealizados.add(p);
                orderPaid = orderPaid && PasareladePagos.pagar(p,identificador);
            }else{
                rollback(pagosRealizados);
            }
        }
        cambiarEstado(orden, pagosRealizados);
        return orderPaid;
    }

    private void cambiarEstado(Order orden, ArrayList<Payment> pagosRealizados) {
        orden.setState(2);
        for(Payment p: pagosRealizados){
            p.setId_pago(pagos.size()+1);
            p.setEstadoTransaccion(2);
            pagos.put(p.getId_pago(), p);
        }
    }


    private void rollback(ArrayList<Payment> pagosRealizados){
        for(Payment p : pagosRealizados){
            p.setEstadoTransaccion(0);
        }
    }
}
