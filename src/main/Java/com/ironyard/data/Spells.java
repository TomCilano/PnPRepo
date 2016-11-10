package com.ironyard.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Tom on 11/9/16.
 */
@Entity
public class Spells {
    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Spells(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Spells(){

    }
}
