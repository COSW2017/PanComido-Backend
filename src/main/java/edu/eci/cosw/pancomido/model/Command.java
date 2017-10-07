package edu.eci.cosw.pancomido.model;

import java.util.HashMap;
import java.util.List;

public class Command {

    private int idPedido;
    private List <Dish> platos;
    private Integer state;

    public Command(){
    }

    public Command(int idPedido, List <Dish> platos){
        this.platos = platos;
        this.idPedido = idPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public List<Dish> getPlatos() {
        return platos;
    }

    public void setPlatos(List<Dish> platos) {
        this.platos = platos;
    }

    public Dish getPlato(int id){
        Dish d = null; boolean found = false;
        for(int i =0; i< platos.size() && !found; i++){
            if(id == platos.get(i).getId_dish()){
                d = platos.get(i);
                found = true;
            }
        }
        return d;
    }

    public Double getMonto(){
        double sum = 0;
        for(Dish d : getPlatos()){
            sum+=d.getPrice();
        }
        return sum;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
