package edu.eci.cosw.pancomido.model;

import java.util.Date;

/**
 * Created by 2100038 on 9/12/17.
 */
public class Comment {

    private String comment;
    private User user;
    private Date date;

    public Comment(String comment, User user, Date date) {
        this.comment = comment;
        this.user = user;
        this.date = date;
    }

    public Comment() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
