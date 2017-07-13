package ru.kabatov.models;

import org.codehaus.jackson.annotate.JsonManagedReference;

public class Message extends Base {
    @JsonManagedReference
    private User user;
    private String text;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}