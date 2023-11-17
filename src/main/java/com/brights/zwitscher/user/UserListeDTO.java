package com.brights.zwitscher.user;

import java.util.List;

public class UserListeDTO {

    private List<User> userListe;

    public UserListeDTO(List<User> userListe) {
        this.userListe = userListe;
    }

    public List<User> getUserListe() {
        return userListe;
    }

    public void setUserListe(List<User> userListe) {
        this.userListe = userListe;
    }
}
