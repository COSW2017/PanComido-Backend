package edu.eci.cosw.pancomido.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2100038 on 9/12/17.
 */
public class Restaurant {

    private Integer id_restaurant;
    private String name;
    private Double latitude;
    private Double longitude;
    private Integer like;
    private Integer dislike;
    private Integer love;
    private Integer angry;
    private List<Comment> comments;
    private List<Dish> dishes;

    public Restaurant(Integer id_restaurant, String name, Double latitude, Double longitude, Integer like, Integer dislike, Integer love, Integer angry) {
        this.id_restaurant = id_restaurant;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.like = like;
        this.dislike = dislike;
        this.love = love;
        this.angry = angry;
        this.dishes = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public Integer getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(Integer id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    public Restaurant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getDislike() {
        return dislike;
    }

    public void setDislike(Integer dislike) {
        this.dislike = dislike;
    }

    public Integer getLove() {
        return love;
    }

    public void setLove(Integer love) {
        this.love = love;
    }

    public Integer getAngry() {
        return angry;
    }

    public void setAngry(Integer angry) {
        this.angry = angry;
    }

    /*public List<Order> getOrders() {
        return orders;
    }*/

    /*public void setOrders(List<Order> orders) {
        this.orders = orders;
    }*/

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Dish getDishById(int id_dish){
        Dish d = null; boolean found = false;
        for(int i =0; i< dishes.size() && !found; i++){
            if(id_dish == dishes.get(i).getId_dish()){
                d = dishes.get(i);
                found = true;
            }
        }
        return d;
    }

    public void delDishById(int id_dish){
        boolean found = false;
        for(int i =0; i< dishes.size() && !found; i++){
            if(id_dish == dishes.get(i).getId_dish()){
                dishes.remove(dishes.get(i));
                found = true;
            }
        }
    }

    public Dish addDish(Dish dish){
        dishes.add(dish);
        return dish;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", like=" + like +
                ", dislike=" + dislike +
                ", love=" + love +
                ", angry=" + angry +
                ", comments=" + comments +
                '}';
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
