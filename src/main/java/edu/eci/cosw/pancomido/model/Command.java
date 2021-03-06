package edu.eci.cosw.pancomido.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "command")
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_command;

    private Integer state;
    public Date creation_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Order id_order;

    public Command(){ }

    public Command(int idPedido, List <Dish> platos){
        this.id_command = idPedido;
    } //¿Se necesitan los platos o no?

    @Column(name="id_command", unique = true, nullable = false)
    public int getId_command() {
        return id_command;
    }

    public void setId_command(int idPedido) {
        this.id_command = idPedido;
    }

    @Column(name="state", nullable = false)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Column(name="creation_date", nullable = false)
    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Order getId_order() {
        return id_order;
    }

    public void setId_order(Order order) {
        this.id_order = order;
    }
}
