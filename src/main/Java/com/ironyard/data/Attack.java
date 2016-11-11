package com.ironyard.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Tom on 11/10/16.
 */
@Entity
public class Attack {
    private String attacks;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Attack(String attacks) {
        this.attacks = attacks;
    }


    public String getAttacks() {
        return attacks;
    }

    public void setAttacks(String attacks) {
        this.attacks = attacks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Attack() {
    }
}

