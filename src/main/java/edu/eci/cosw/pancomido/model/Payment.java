package edu.eci.cosw.pancomido.model;

import java.util.Date;

public class Payment {
    private Integer id_pago;
    private Order orden;
    private Date fecha_pago;
    private Integer estadoTransaccion;
    private MetodoPago metodo;
    private User usuario;
    private Double monto;

    public Payment(User usuario, Double monto, Order orden){
        this.usuario = usuario;
        this.orden = orden;
        this.monto = monto;
    }

    public Integer getId_pago() {
        return id_pago;
    }

    public void setId_pago(Integer id_pago) {
        this.id_pago = id_pago;
    }

    public Order getOrden() {
        return orden;
    }

    public void setOrden(Order orden) {
        this.orden = orden;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public Integer getEstadoTransaccion() {
        return estadoTransaccion;
    }

    public void setEstadoTransaccion(Integer estadoTransaccion) {
        this.estadoTransaccion = estadoTransaccion;
    }

    public MetodoPago getMetodo() {
        return metodo;
    }

    public void setMetodo(MetodoPago metodo) {
        this.metodo = metodo;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }


    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getMonto() {
        return monto;
    }
}
