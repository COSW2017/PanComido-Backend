package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.model.MetodoPago;
import edu.eci.cosw.pancomido.model.Order;

public interface PagoService {

    public boolean pagarOrden(Order orden, MetodoPago metodoPago, int identificador);
}
