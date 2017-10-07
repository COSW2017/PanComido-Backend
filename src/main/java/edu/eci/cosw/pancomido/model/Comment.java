package edu.eci.cosw.pancomido.model;

import java.util.Date;

/**
 * Created by 2100038 on 9/12/17.
 */
public class Comment {

    private String comment;
    private Date date;

    public Comment(String comment, Date date) {
        this.comment = comment;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
