package com.ironyard.data;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Tom on 11/15/16.
 */
@Entity
public class StoryObj {
    @Size(max = 300000)
    private String story;
    private String date;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public StoryObj() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
