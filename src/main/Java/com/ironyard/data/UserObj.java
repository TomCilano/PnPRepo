package com.ironyard.data;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Tom on 11/8/16.
 */
@Entity
public class UserObj {
    private String userName;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Skills> skills;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Spells> spells;

//    @ManyToMany(cascade = CascadeType.ALL)
//    private Set<Features> features;




    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public UserObj() {

    }


//    public Set<Features> getFeatures() {
//        return features;
//    }
//
//    public void setFeatures(Set<Features> features) {
//        this.features = features;
//    }

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

    public Set<Skills> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skills> skills) {
        this.skills = skills;
    }

    public Set<Spells> getSpells() {
        return spells;
    }

    public void setSpells(Set<Spells> spells) {
        this.spells = spells;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}