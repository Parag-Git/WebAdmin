package com.lti.authorization1.Model;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private static String userName;
    private static String password;
    private boolean active;
    private static String roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public static String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
