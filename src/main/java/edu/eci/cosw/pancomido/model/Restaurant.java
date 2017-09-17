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
    private List<Order> orders;
    private List<Comment> comments;
    private List<Dish> dishes;

    public Restaurant(Integer id, String name, Double latitude, Double longitude, Integer like, Integer dislike, Integer love, Integer angry, List<Order> orders, List<Comment> comments) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.like = like;
        this.dislike = dislike;
        this.love = love;
        this.angry = angry;
        this.orders = orders;
        this.comments = comments;
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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
                ", orders=" + orders +
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
