package com.brights.zwitscher.user;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
public class UserRegistrierenDTO {

    @NotEmpty(message = "Der Benutzername darf nicht leer sein.")
    @Size(min = 3, max = 20, message = "Der Benutzername muss zwischen 3 und 20 Zeichen lang sein.")
    private String username;

    @NotEmpty(message = "Das Passwort darf nicht leer sein.")
    @Size(min = 6, message = "Das Passwort muss mindestens 6 Zeichen lang sein.")
    private String password;

    @NotEmpty(message = "Die Passwortbestätigung darf nicht leer sein.")
    @Size(min = 6, message = "")
    private String passwordBestätigung;

    @NotEmpty(message = "Die E-Mail-Adresse darf nicht leer sein.")
    @Email(message = "Ungültige E-Mail-Adresse.")
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
