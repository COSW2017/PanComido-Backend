package edu.eci.cosw.pancomido.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NGS on 9/12/17.
 */
public class Order {

    private Integer id_order;
    private User user;
    private List<Command> commands;


    public Order() {
    }

    public Order(Integer id_order, User user, List<Command> commands) {
        this.id_order = id_order;
        this.user = user;
        this.commands = commands;
    }

    public Integer getId() {
        return id_order;
    }

    public void setId(Integer id_order) {
        this.id_order = id_order;
    }

    public User getUser() {
        return user;
    }

    public void setUsers(User user) {
        this.user = user;
    }

    public void addPedido(Command p){
        this.getCommands().add(p);
    }

    public Command getPedidoById(int id){
        return commands.get(id);
    }

    public void delPedido(int idPedido){
        List<Command> pedidosBack = getCommands();
        boolean found = false;
        for(int i=0; i<pedidosBack.size() && !found; i++){
            if(idPedido== getCommands().get(i).getIdPedido()){
                getCommands().remove(getCommands().get(i));
                found=true;
            }
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id_order +
                ", users=" + user +
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
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }
    /*
    En cola: 0, En progreso: 1, Listo=2
     */
    public boolean isReady(){
        Boolean ready = true;
        for(Command p : commands){
            ready = ready && p.getState()== 2 ? true : false;
        }
        return ready;
    }

    //ToDo: falta calcular los pagos

}
