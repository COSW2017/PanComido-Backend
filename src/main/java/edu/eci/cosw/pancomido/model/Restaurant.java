package edu.eci.cosw.pancomido.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2100038 on 9/12/17.
 */

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_restaurant;

    private String name;
    private Float latitude;
    private Float longitude;
    private Integer likes;
    private Integer dislike;
    private Integer love;
    private Integer angry;
    private String image;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    private User user_id;

    public Restaurant(Integer id_restaurant, String name, Float latitude, Float longitude, Integer like, Integer dislike, Integer love, Integer angry) {
        this.id_restaurant = id_restaurant;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.likes = like;
        this.dislike = dislike;
        this.love = love;
        this.angry = angry;
    }


    public Restaurant() { }

    @Column(name="id_restaurant", unique = true, nullable = false)
    public Integer getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(Integer id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    @Column(name="name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="latitude", nullable = false)
    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    @Column(name="longitude", nullable = false)
    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    @Column(name="likes", nullable = false)
    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer like) {
        this.likes = like;
    }

    @Column(name="dislike", nullable = false)
    public Integer getDislike() {
        return dislike;
    }

    public void setDislike(Integer dislike) {
        this.dislike = dislike;
    }

    @Column(name="love", nullable = false)
    public Integer getLove() {
        return love;
    }

    public void setLove(Integer love) {
        this.love = love;
    }

    @Column(name="angry", nullable = false)
    public Integer getAngry() {
        return angry;
    }

    public void setAngry(Integer angry) {
        this.angry = angry;
    }


    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    @Column(name="image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /*public List<Order> getOrders() {
        return orders;
    }*/

    /*public void setOrders(List<Order> orders) {
        this.orders = orders;
    }*/
}
