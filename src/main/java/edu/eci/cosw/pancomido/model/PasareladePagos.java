package edu.eci.cosw.pancomido.model;

import java.util.Random;

public class PasareladePagos {

    private static final int maxValue = 100000;
    private static int monto;

    public static boolean pagar(Payment pago, int identificador){
        setMonto();
        boolean pagado = true;
        switch (identificador){
            case 0:
                pagado = false; break;
            case 1:
                pagado = pago.getMonto()< monto; break;
            case 2:
                pagado = true; break;
        }
        return pagado;
    }

    private static void setMonto(){
      Random r = new Random();
      monto = r.nextInt(maxValue);
    }

}
