package edu.eci.cosw.pancomido.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
public class User {
    private long id_user;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String city;
    private String image;
    public String cellphone;
    public List<Order> orders;
    public List<User> friends;
    public List<User> pendingFriends;
    private Restaurant restaurant;

    public User(){}

    public User( String email, String password, String firstname, String lastname, String image, String city, String cellphone)
    {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.image = image;
        this.city = city;
        this.cellphone = cellphone;
        orders = new ArrayList<>();
        friends = new ArrayList<>();
        pendingFriends = new ArrayList<>();
    }


    public long getId()
    {
        return id_user;
    }

    public void setId( long id_user )
    {
        this.id_user = id_user;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname( String firstname )
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname( String lastname )
    {
        this.lastname = lastname;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<User> getPendingFriends() {
        return pendingFriends;
    }

    public void setPendingFriends(List<User> pendingFriends) {
        this.pendingFriends = pendingFriends;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString()
    {
        return "User{" + "id=" + id_user + ", email='" + email + '\'' + ", password='" + password + '\'' + ", firstname='"
            + firstname + '\'' + '}';
    }
}
