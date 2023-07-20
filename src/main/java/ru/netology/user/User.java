package ru.netology.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class User {
    @NotBlank
    @Size(min = 2, max = 30)
    private String user;
    @NotBlank
    @Size(min = 8, max = 30)
    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }
}
