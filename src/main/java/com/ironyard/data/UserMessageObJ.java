package com.ironyard.data;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;


/**
 * Created by Tom on 11/14/16.
 */
@Entity
public class UserMessageObJ {
    @Size(max = 1337)
    private String message;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //  "date": "2016-11-22T20:49:12.637Z"
    @JsonFormat(pattern = "yyyy/mm/ddT7Ihh:ss")
    private Date date;

    public UserMessageObJ() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
