package edu.eci.ieti.controller.auth;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class LoginDto
{
    String email;

    String password;

    public LoginDto() {
    }

    public LoginDto(String email, String password )
    {
        this.email = email;
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    @Override
    public String toString() {
        return "LoginDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}