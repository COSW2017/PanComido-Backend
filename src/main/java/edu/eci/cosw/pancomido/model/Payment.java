package edu.eci.cosw.pancomido.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_payment;
    private Date payment_date;
    private Integer transaction_state;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_command", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Command id_command;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    private User user;

    public Payment(User usuario, Command command){
        this.user = usuario;
        this.id_command = command;
    }

    @Column(name="payment_id", unique = true, nullable = false)
    public Integer getId_payment() {
        return id_payment;
    }

    public void setId_payment(Integer id_payment) {
        this.id_payment = id_payment;
    }

    @Column(name="payment_date", nullable = false)
    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    @Column(name="transaction_state", nullable = false)
    public Integer getTransaction_state() {
        return transaction_state;
    }

    public void setTransaction_state(Integer transactionState) {
        this.transaction_state = transactionState;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Command getId_command(){
        return id_command;
    }

    public void setId_command(Command command) {
        this.id_command = command;
    }

    public Double getMonto() {
        return id_command.getMonto();
    }
}
