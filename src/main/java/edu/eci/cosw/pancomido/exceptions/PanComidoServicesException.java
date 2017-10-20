package edu.eci.cosw.pancomido.exceptions;

public class PanComidoServicesException extends Exception{

    public static final String NO_METODO_DE_PAGO = "El usuario no tiene configurado un método de pago";

    public static final String NO_SE_PUEDE_CANCELAR_ORDEN = "No se puede cancelar la orden";

    public PanComidoServicesException(String mensaje){
        super(mensaje);
    }
}
