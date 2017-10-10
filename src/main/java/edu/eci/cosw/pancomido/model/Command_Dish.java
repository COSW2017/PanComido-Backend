package edu.eci.cosw.pancomido.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "command_dish")
public class Command_Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_command_dish;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_command", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Command id_command;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dish", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Dish id_dish;

    @Column(name="id_command_dish", unique = true, nullable = false)
    public int getId_command_dish() {
        return id_command_dish;
    }

    public void setId_command_dish(int id_command_dish) {
        this.id_command_dish = id_command_dish;
    }

    public Command getId_command() {
        return id_command;
    }

    public void setId_command(Command id_command) {
        this.id_command = id_command;
    }

    public Dish getId_dish() {
        return id_dish;
    }

    public void setId_dish(Dish id_dish) {
        this.id_dish = id_dish;
    }
}
