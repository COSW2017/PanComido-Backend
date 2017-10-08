package edu.eci.cosw.pancomido.service;

import edu.eci.cosw.pancomido.model.Dish;
import edu.eci.cosw.pancomido.model.Order;
import edu.eci.cosw.pancomido.model.Command;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    HashMap<Integer, Order> ordenes = new HashMap<>();

    /*
    @Override
    public Boolean changeCommandState(Integer id_order, Integer id_pedido, Integer state) {
        Order order = ordenes.get(id_order);
        List<Command> commands = order.getCommands();
        Boolean found = false;
        for(int i = 0; i< commands.size() && !found; i++){
            if(commands.get(i).getIdPedido()==id_pedido){
                commands.get(i).setState(state);
                found=true;
            }
        }
        if(order.isReady()){
            order.setState(2);
        }
        return found;
    }*/

    /*@Override
    public Order getOrdersById(Integer id_restaurant, Integer id_order) {
        return null;
    }*/

    @Override
    public Order getOrderById(Integer id_order) {
        return ordenes.get(id_order);
    }

   /* @Override
    public List<Order> getOrdersByRestaurant(Integer id_restaurant) {
        List<Dish> platos; List<Order> ordenesRestaurante = new ArrayList<>();
        for (Integer i : ordenes.keySet()){
            platos = ordenes.get(i).getDishes(); boolean notFound = true;
            for(int d = 0; d< platos.size() && notFound; d++){
                if(platos.get(d).getRestaurant().getId_restaurant().equals(id_restaurant)){
                    ordenesRestaurante.add(ordenes.get(i));
                    notFound = false;
                }
            }
        }
        return ordenesRestaurante;
    }*/

    public List<Command> getPedidosByRestaurant(Integer id_restaurant){
        List<Command> commands = new ArrayList<>();
        List<Command> commandPorOrden; Dish d;
        for(Integer i : ordenes.keySet()){
            commandPorOrden = ordenes.get(i).getCommands();
            /*if(commandPorOrden.get(i).getPlatos().get(0).getRestaurant().getId_restaurant()==id_restaurant){
                commands.add(commandPorOrden.get(i));
            }*/
        }
        return commands;
    }

    public Order addOrder(Order order){
        ordenes.put(order.getId_order(), order);
        return order;
    }


 }
