package com.ironyard.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Tom on 11/10/16.
 */
@Entity
public class Attacks {
    private String attacks;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Attacks() {

    }

    public String getAttacks() {
        return attacks;
    }

    public void setAttacks(String attacks) {
        this.attacks = attacks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

