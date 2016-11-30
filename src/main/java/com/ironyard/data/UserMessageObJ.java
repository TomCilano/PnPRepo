package com.ironyard.data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;



/**
 * Created by Tom on 11/14/16.
 */
@Entity
public class UserMessageObJ {
    @Size(max = 10000)
    private String message;
    private String  date;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public UserMessageObJ() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
