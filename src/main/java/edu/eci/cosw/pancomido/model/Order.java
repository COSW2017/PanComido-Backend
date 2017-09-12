package edu.eci.cosw.pancomido.model;

import java.util.List;

/**
 * Created by NGS on 9/12/17.
 */
public class Order {

    private Integer id;
    private List<Restaurant> restaurants;
    private List<User> users;
    private List<Dish> dishes;

    public Order() {
    }

    public Order(Integer id, List<Restaurant> restaurants, List<User> users, List<Dish> dishes) {
        this.id = id;
        this.restaurants = restaurants;
        this.users = users;
        this.dishes = dishes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", restaurants=" + restaurants +
                ", users=" + users +
                ", dishes=" + dishes +
                '}';
    }
}
