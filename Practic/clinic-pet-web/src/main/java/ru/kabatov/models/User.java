package ru.kabatov.models;

import java.util.List;

/**
 * TODO: comment
 * @author parsentev
 * @since 17.04.2015
 */
public class User extends Base {
    private String login;
    private String email;
    private String agree;
    private String city;
    private String sex;

    public User(final int id, String login, String email, String agree, String city, String sex) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.agree = agree;
        this.city = city;
        this.sex = sex;
    }

    public User(final int id,String login, String email, String city) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.city = city;
    }

    public String getAgree() {
        return agree;
    }

    public void setAgree(String agree) {
        this.agree = agree;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private Role role;
    private List<Message> messages;

    public User() {
    }

    public User(final int id, final String login, final String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getLogin() {
        return this.login;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
