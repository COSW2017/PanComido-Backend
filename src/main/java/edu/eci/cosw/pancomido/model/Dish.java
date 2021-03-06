package edu.eci.cosw.pancomido.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

/**
 * Created by 2100038 on 9/12/17.
 */
@Entity
@Table(name = "dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_dish;

    private String name;
    private Integer price;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_restaurant", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Restaurant restaurant;

    private Integer prep_time;
    private String image;

    public Dish(Integer id_dish, String name, Integer price, String description, Restaurant restaurant) {
        this.id_dish = id_dish;
        this.name = name;
        this.price = price;
        this.description = description;
        this.restaurant = restaurant;
    }

    public Dish() {
    }

    @Column(name="image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name="id_dish", unique = true, nullable = false)
    public Integer getId_dish() {
        return id_dish;
    }

    public void setId_dish(Integer id_dish) {
        this.id_dish = id_dish;
    }

    @Column(name="name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="price", nullable = false)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Column(name="description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id_dish=" + id_dish +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", restaurant=" + restaurant +
                ", prep_time=" + prep_time +
                ", image='" + image + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (!id_dish.equals(dish.id_dish)) return false;
        if (!getName().equals(dish.getName())) return false;
        if (!getPrice().equals(dish.getPrice())) return false;
        return getDescription().equals(dish.getDescription());
    }

    @Override
    public int hashCode() {
        int result = id_dish.hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getPrice().hashCode();
        result = 31 * result + getDescription().hashCode();
        return result;
    }


    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Column(name="prep_time", nullable = false)
    public Integer getPrep_time() {
        return prep_time;
    }

    public void setPrep_time(Integer tiempoPreparacion) {
        this.prep_time = tiempoPreparacion;
    }
}