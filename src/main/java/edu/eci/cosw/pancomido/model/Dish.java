package edu.eci.cosw.pancomido.model;

/**
 * Created by 2100038 on 9/12/17.
 */
public class Dish {

    private Integer id_dish;
    private String name;
    private Integer price;
    private String description;

    public Dish(Integer id_dish, String name, Integer price, String description) {
        this.id_dish = id_dish;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Dish() {
    }

    public Integer getId_dish() {
        return id_dish;
    }

    public void setId_dish(Integer id_dish) {
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
}