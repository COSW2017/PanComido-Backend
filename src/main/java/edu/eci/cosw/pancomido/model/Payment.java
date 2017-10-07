package edu.eci.cosw.pancomido.model;

import java.util.Date;

public class Payment {
    private Integer id_pago;
    private Command command;
    private Date fecha_pago;
    private Integer estadoTransaccion;
    private User usuario;

    public Payment(User usuario, Command command){
        this.usuario = usuario;
        this.command = command;
    }

    public Integer getId_pago() {
        return id_pago;
    }

    public void setId_pago(Integer id_pago) {
        this.id_pago = id_pago;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
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

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Double getMonto() {
        return command.getMonto();
    }
}
