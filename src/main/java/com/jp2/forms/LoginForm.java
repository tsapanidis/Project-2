package com.jp2.forms;

import javax.validation.constraints.Pattern;

public class LoginForm {

    @Pattern(regexp = "^(.+)@(.+)$")
    private String email;

    private String Pass;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }
}
