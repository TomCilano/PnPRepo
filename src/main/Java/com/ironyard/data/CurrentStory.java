package com.ironyard.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Tom on 11/14/16.
 */
@Entity
public class CurrentStory {
    private String story;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public CurrentStory() {
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

