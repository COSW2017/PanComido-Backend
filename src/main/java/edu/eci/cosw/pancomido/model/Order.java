package edu.eci.cosw.pancomido.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by NGS on 9/12/17.
 */
@Entity
@Table(name = "rest_order")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_order;
    private Date creation_date;

    //private List<Command> commands; //Falta guardar los pedidos

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    private User user_id;


    public Order() {
    }

    public Order(Integer id_order, User user) {
        this.id_order = id_order;
        this.user_id = user;
    }

    @Column(name="id_order", unique = true, nullable = false)
    public Integer getId_order() {
        return id_order;
    }

    public void setId_order(Integer id_order) {
        this.id_order = id_order;
    }


    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user) {
        this.user_id = user;
    }

    public void addPedido(Command p){
        this.getCommands().add(p);
    }

    public Command getPedidoById(int id){
        return null;
    }

    public void delPedido(int idPedido){
        List<Command> pedidosBack = getCommands();
        boolean found = false;
        for(int i=0; i<pedidosBack.size() && !found; i++){
            if(idPedido== getCommands().get(i).getId_command()){
                getCommands().remove(getCommands().get(i));
                found=true;
            }
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id_order +
                ", users=" + "" +
                '}';
    }

    public Double getMonto(){
        double sum = 0;
        for(Command d : getCommands()){
            sum+=d.getMonto();
        }
        return sum;
    }


    public List<Command> getCommands() {
        return null;//this.commands;
    }

    public void setCommands(List<Command> commands) {
        //this.commands = commands;
    }
    /*
    En cola: 0, En progreso: 1, Listo=2
     */
    public boolean isReady(){
        Boolean ready = true;
        /*for(Command p : commands){
            ready = ready && p.getState()== 2 ? true : false;
        }*/
        return ready;
    }

    @Column(name = "creation_date", nullable = false)
    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    //ToDo: falta calcular los pagos

}
