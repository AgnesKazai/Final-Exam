package com.greenfoxcompany.connectionwithmysql.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private Boolean done;
    private Boolean urgent;

    public Todo() {
        this.urgent = true;
        this.done = false;
    }

    public Todo(String title, Boolean done, Boolean urgent) {
        this.title = title;
        this.urgent = urgent;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Boolean getUrgent() {
        return urgent;
    }

    public void setUrgent(Boolean urgent) {
        this.urgent = urgent;
    }
}
