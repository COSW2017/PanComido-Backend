package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;


@Service
public class PagoServiceImpl implements PagoService{

    private HashMap<Integer, Pago> pagos = new HashMap<>();

    public boolean pagarOrden(Order orden, MetodoPago metodoPago, int identificador){
        ArrayList<Pago> pagosRealizados= new ArrayList<>();
        Double monto = orden.getMonto()/orden.getUsers().size();
        boolean orderPaid = true; Pago p; User u;
        for(int i = 0; i<orden.getUsers().size() && orderPaid; i++){
            u = orden.getUsers().get(i);
            orderPaid= orderPaid && metodoPago.isValid();
            if(orderPaid){
                p =new Pago(u, monto, orden); pagosRealizados.add(p);
                orderPaid = orderPaid && PasareladePagos.pagar(p,identificador);
            }else{
                rollback(pagosRealizados);
            }
        }
        cambiarEstado(orden, pagosRealizados);
        return orderPaid;
    }

    private void cambiarEstado(Order orden, ArrayList<Pago> pagosRealizados) {
        orden.setState(2);
        for(Pago p: pagosRealizados){
            p.setId_pago(pagos.size()+1);
            p.setEstadoTransaccion(2);
            pagos.put(p.getId_pago(), p);
        }
    }


    private void rollback(ArrayList<Pago> pagosRealizados){
        for(Pago p : pagosRealizados){
            p.setEstadoTransaccion(0);
        }
    }
}
