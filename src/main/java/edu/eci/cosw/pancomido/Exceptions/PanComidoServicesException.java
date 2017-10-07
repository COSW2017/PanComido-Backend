package edu.eci.cosw.pancomido.Exceptions;

public class PanComidoServicesException extends Exception{

    public static final String NO_METODO_DE_PAGO = "El usuario no tiene configurado un método de pago";

    public PanComidoServicesException(String mensaje){
        super(mensaje);
    }
}
