package com.ironyard.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Tom on 11/10/16.
 */
@Entity
public class CurrentState {
    private int armorClass;
    private int initiative;
    private int speed;
    private int maxHitPoints;
    private int cirrentHitPoints;
    private int hitDice;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public CurrentState() {
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public void setMaxHitPoints(int maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
    }

    public int getCirrentHitPoints() {
        return cirrentHitPoints;
    }

    public void setCirrentHitPoints(int cirrentHitPoints) {
        this.cirrentHitPoints = cirrentHitPoints;
    }

    public int getHitDice() {
        return hitDice;
    }

    public void setHitDice(int hitDice) {
        this.hitDice = hitDice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
