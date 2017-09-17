package edu.eci.cosw.pancomido.model;

import java.util.List;

/**
 * Created by NGS on 9/12/17.
 */
public class Order {

    private Integer id_order;
    private List<Restaurant> restaurants;
    private List<User> users;
    private List<Dish> dishes;
    private Integer state;

    public Order() {
    }

    public Order(Integer id_order, List<Restaurant> restaurants, List<User> users, List<Dish> dishes, Integer state) {
        this.id_order = id_order;
        this.restaurants = restaurants;
        this.users = users;
        this.dishes = dishes;
        this.state = state;
    }

    public Integer getId() {
        return id_order;
    }

    public void setId(Integer id_order) {
        this.id_order = id_order;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id_order +
                ", restaurants=" + restaurants +
                ", users=" + users +
                ", dishes=" + dishes +
                '}';
    }
}
