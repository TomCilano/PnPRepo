package com.ironyard.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tom on 11/8/16.
 */
@Entity
public class User {
    private String userName;
    private String password;
    private HashMap<Integer, String> stats;
    private List spells;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public User(String userName, String password, HashMap<Integer, String> stats, List spells) {
        this.userName = userName;
        this.password = password;
        this.stats = stats;
        this.spells = spells;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashMap<Integer, String> getStats() {
        return stats;
    }

    public void setStats(HashMap<Integer, String> stats) {
        this.stats = stats;
    }

    public List getSpells() {
        return spells;
    }

    public void setSpells(List spells) {
        this.spells = spells;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
