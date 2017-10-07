package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.Exceptions.PanComidoServicesException;
import edu.eci.cosw.pancomido.model.Command;
import edu.eci.cosw.pancomido.model.Order;
import edu.eci.cosw.pancomido.model.User;

public interface PagoService {

    public boolean payCommand(Command command, User user, int identificador) throws PanComidoServicesException;
}
