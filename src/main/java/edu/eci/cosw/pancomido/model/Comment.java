package edu.eci.cosw.pancomido.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 2100038 on 9/12/17.
 */
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_comment;

    private String comment_des;
    private Date comment_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_restaurant", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Restaurant id_restaurant;

    public Comment(String comment, Date date) {
        this.comment_des = comment;
        this.comment_date = date;
    }

    public Comment() {
    }

    @Column(name="id_comment", unique = true, nullable = false)
    public int getId_comment() {
        return id_comment;
    }

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
    }

    public Restaurant getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(Restaurant id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    @Column(name="comment_des", nullable = false)
    public String getComment_des() {
        return comment_des;
    }

    public void setComment_des(String comment_des) {
        this.comment_des = comment_des;
    }

    @Column(name="comment_date", nullable = false)
    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }
}
