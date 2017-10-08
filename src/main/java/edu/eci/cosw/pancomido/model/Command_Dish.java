package edu.eci.cosw.pancomido.model;

import javax.persistence.*;

@Entity
@Table(name = "command")
public class Command_Dish {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id_command_dish;
    private int id_command;
    private int id_dish;

    @Column(name="id_command_dish", unique = true, nullable = false)
    public int getId_command_dish() {
        return id_command_dish;
    }

    public void setId_command_dish(int id_command_dish) {
        this.id_command_dish = id_command_dish;
    }

    @Column(name="id_command", nullable = false)
    public int getId_command() {
        return id_command;
    }

    public void setId_command(int id_command) {
        this.id_command = id_command;
    }

    @Column(name="id_dish", nullable = false)
    public int getId_dish() {
        return id_dish;
    }

    public void setId_dish(int id_dish) {
        this.id_dish = id_dish;
    }
}
