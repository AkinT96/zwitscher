package com.brights.zwitscher.user;

public class UserRegistrierenDTO {
    private String username;
    private String password;
    private String passwordBestätigung;
    private String email;

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

    public String getPasswordBestätigung() {
        return passwordBestätigung;
    }

    public void setPasswordBestätigung(String passwordBestätigung) {
        this.passwordBestätigung = passwordBestätigung;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
