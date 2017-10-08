package edu.eci.cosw.pancomido.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long user_id;

    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String city;
    private String image;
    private String cellphone;

    private int selectedPaymentMethod;

    /*public List<Order> orders;
    public List<User> friends;
    public List<User> pendingFriends;
    private List<PaymentMethod> metodosPaymentMethods;
    private List<Payment> pagos;*/
    public User(){}

    public User( String email, String password, String firstname, String lastname, String image, String city, String cellphone) {
        this.setPassword(password);
        this.setFirstname(firstname);
        this.setEmail(email);
        this.setLastname(lastname);
        this.setImage(image);
        this.setCity(city);
        this.setCellphone(cellphone);
        /*orders = new ArrayList<>();
        friends = new ArrayList<>();
        pendingFriends = new ArrayList<>();
        metodosPaymentMethods = new ArrayList<>();*/
        selectedPaymentMethod = -1;
    }
    /*public List<Payment> getPagos() {return pagos;}
    public void setPagos(List<Payment> pagos) {
        this.pagos = pagos;
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

    public void addMetodoPago(PaymentMethod paymentMethod){
        metodosPaymentMethods.add(paymentMethod);
    }*/

    public PaymentMethod getPaymentMethod(){
        return null;
    }

    @Column(name="user_id", unique = true, nullable = false)
    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    @Column(name="email", unique = true, nullable = false)
    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="firstname", nullable = false)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name="lastname", nullable = false)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name="city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name="image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name="cellphone")
    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    @Override
    public String toString()
    {
        return "User{" + "id=" + getUser_id() + ", email='" + getEmail() + '\'' + ", password='" + getPassword() + '\'' + ", firstname='"
                + getFirstname() + '\'' + '}';
    }
}
