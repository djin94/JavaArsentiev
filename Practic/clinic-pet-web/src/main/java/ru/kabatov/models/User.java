package ru.kabatov.models;

import org.codehaus.jackson.annotate.JsonBackReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * TODO: comment
 * @author parsentev
 * @since 17.04.2015
 */
public class User extends Base {
    private String login;
    private String email;
    private String city;
    private String sex;
    private String agree;
    private Role role;
    @JsonBackReference
    private Set<Message> messages;
    private ArrayList<Role> roles = new ArrayList<>();

    public User() {
    }

    public User(final int id, final String login, final String email, final String city) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.city = city;
    }

    public User(final int id, String login, String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }

    public User(final int id, String login, String email, String city, String sex, String agree, Role role) {
        this.id=id;
        this.login = login;
        this.email = email;
        this.city = city;
        this.sex = sex;
        this.agree = agree;
        this.role = role;
    }

    public User(final int id, String login, String email, String city, String sex, String agree, Role role, Set<Message> messages) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.city = city;
        this.sex = sex;
        this.agree = agree;
        this.role = role;
        this.messages = messages;
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

    public String getAgree() {
        return agree;
    }

    public void setAgree(String agree) {
        this.agree = agree;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public String getLogin() {
        return this.login;
    }

    public String getEmail() {
        return this.email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
