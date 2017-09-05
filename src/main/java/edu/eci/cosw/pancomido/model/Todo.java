package edu.eci.cosw.pancomido.model;

public class Todo {
    private String description;
    private Integer priority;
    private Boolean completed;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Todo()
    {
    }

    public Todo(String description, Integer priority, Boolean completed) {
        this.description = description;
        this.completed = completed;
        this.priority = priority;
    }
}