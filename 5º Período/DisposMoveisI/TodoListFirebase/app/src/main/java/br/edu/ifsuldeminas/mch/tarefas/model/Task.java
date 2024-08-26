package br.edu.ifsuldeminas.mch.tarefas.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Task implements Serializable {
    private String id;
    private String description;
    private boolean active;

    private Date dateChanged;

    public Task() {
        setActive(true);
    }

    public Task(String id, String description) {
        this.id = id;
        setDescription(description);
        setActive(true);
        setDateChanged();
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateChanged() {
        return dateChanged;
    }

    public void setDateChanged() {
        dateChanged = Calendar.getInstance().getTime();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return this.getDescription();
    }
}
