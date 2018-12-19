package com.jp2.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class LoginResponse {
    private String username;
    private String password;
    private List<GrantedAuthority> roles;


    public LoginResponse(String username, String password, List<GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.roles = authorities;

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

    public List<GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(List<GrantedAuthority> roles) {
        this.roles = roles;
    }
}
