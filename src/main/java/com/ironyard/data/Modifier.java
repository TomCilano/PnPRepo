package com.ironyard.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Tom on 11/10/16.
 */
@Entity
public class Modifier {
    private int inspiration;
    private int proficiency;
    private int savingStr;
    private int savingDex;
    private int savingCon;
    private int savingInt;
    private int savingWis;
    private int savingChar;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Modifier() {
    }

    public int getInspiration() {
        return inspiration;
    }

    public void setInspiration(int inspiration) {
        this.inspiration = inspiration;
    }

    public int getProficiency() {
        return proficiency;
    }

    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }

    public int getSavingStr() {
        return savingStr;
    }

    public void setSavingStr(int savingStr) {
        this.savingStr = savingStr;
    }

    public int getSavingDex() {
        return savingDex;
    }

    public void setSavingDex(int savingDex) {
        this.savingDex = savingDex;
    }

    public int getSavingCon() {
        return savingCon;
    }

    public void setSavingCon(int savingCon) {
        this.savingCon = savingCon;
    }

    public int getSavingInt() {
        return savingInt;
    }

    public void setSavingInt(int savingInt) {
        this.savingInt = savingInt;
    }

    public int getSavingWis() {
        return savingWis;
    }

    public void setSavingWis(int savingWis) {
        this.savingWis = savingWis;
    }

    public int getSavingChar() {
        return savingChar;
    }

    public void setSavingChar(int savingChar) {
        this.savingChar = savingChar;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}