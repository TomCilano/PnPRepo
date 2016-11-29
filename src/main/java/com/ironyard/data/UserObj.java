package com.ironyard.data;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by Tom on 11/8/16.
 */
@Entity
public class UserObj {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userName;
    private String password;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Attack> attackSet;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CurrentState> currentStateSet;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Equipment> equipmentSet;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Feature> featureSet;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<MainStat> mainStatSet;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Modifier> modifierSet;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Skill> skills;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Spell> spellSet;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Tenet> tenetsSet;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserInformation> userInformationSet;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserMessageObJ> userMessageObJSet;


    public UserObj() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Set<Attack> getAttackSet() {
        return attackSet;
    }

    public void setAttackSet(Set<Attack> attackSet) {
        this.attackSet = attackSet;
    }

    public Set<CurrentState> getCurrentStateSet() {
        return currentStateSet;
    }

    public void setCurrentStateSet(Set<CurrentState> currentStateSet) {
        this.currentStateSet = currentStateSet;
    }

    public Set<Equipment> getEquipmentSet() {
        return equipmentSet;
    }

    public void setEquipmentSet(Set<Equipment> equipmentSet) {
        this.equipmentSet = equipmentSet;
    }

    public Set<Feature> getFeatureSet() {
        return featureSet;
    }

    public void setFeatureSet(Set<Feature> featureSet) {
        this.featureSet = featureSet;
    }

    public Set<MainStat> getMainStatSet() {
        return mainStatSet;
    }

    public void setMainStatSet(Set<MainStat> mainStatSet) {
        this.mainStatSet = mainStatSet;
    }

    public Set<Modifier> getModifierSet() {
        return modifierSet;
    }

    public void setModifierSet(Set<Modifier> modifierSet) {
        this.modifierSet = modifierSet;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Set<Spell> getSpellSet() {
        return spellSet;
    }

    public void setSpellSet(Set<Spell> spellSet) {
        this.spellSet = spellSet;
    }

    public Set<Tenet> getTenetsSet() {
        return tenetsSet;
    }

    public void setTenetsSet(Set<Tenet> tenetsSet) {
        this.tenetsSet = tenetsSet;
    }

    public Set<UserInformation> getUserInformationSet() {
        return userInformationSet;
    }

    public void setUserInformationSet(Set<UserInformation> userInformationSet) {
        this.userInformationSet = userInformationSet;
    }

    public Set<UserMessageObJ> getUserMessageObJSet() {
        return userMessageObJSet;
    }

    public void setUserMessageObJSet(Set<UserMessageObJ> userMessageObJSet) {
        this.userMessageObJSet = userMessageObJSet;
    }
}