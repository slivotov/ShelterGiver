package ru.stason.study.spring.persist.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    private int id;
    private String userName;
    private String password;
    private String email;

    public User() {
    }

    public User(final String userName, final String password, final String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    @Column(name = "user_name", nullable = false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
}
