package edu.eci.cosw.pancomido.model;

/**
 * Created by 2100038 on 9/12/17.
 */
public class Dish {

    private Integer id_dish;
    private Integer id_restaurante;
    private String name;
    private Integer price;
    private String description;

    public Dish(Integer id_dish, String name, Integer price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Dish() {
    }

    public Integer getId() {
        return id_dish;
    }

    public void setId(Integer id_dish) {
        this.id_dish = id_dish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id_dish +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(Integer id_restaurante) {
        this.id_restaurante = id_restaurante;
    }
}
