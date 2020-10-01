package com.lti.authorization1.Model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;



public class AuthenticationRequest implements Serializable {






    private String username;

    private String password;

    private boolean active;
    private List<GrantedAuthority> authorities;

    public AuthenticationRequest(User1 user) {
        this.username = user.getUserName();
        this.password = user.getPassword();
        this.active = user.isActive();
        this.authorities = Arrays.stream(user.getRoles().split(","))
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
    }
    public String getUsername() {

        return username;

    }



    public void setUsername(String username) {

        this.username = username;

    }



    public String getPassword() {

        return password;

    }



    public void setPassword(String password) {

        this.password = password;

    }



    //need default constructor for JSON Parsing

    public AuthenticationRequest()

    {



    }



    public AuthenticationRequest(String username, String password) {

        this.setUsername(username);

        this.setPassword(password);

    }


}
