package edu.eci.cosw.pancomido.model;

/**
 * Created by 2100038 on 9/12/17.
 */
public class Dish {

    private Integer id;
    private String name;
    private Integer price;
    private String description;

    public Dish(Integer id, String name, Integer price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Dish() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
