package com.brights.zwitscher.artikel;

import com.brights.zwitscher.user.User;

public class KommentarDTO {
    private String text;
    private User user;
    private Artikel artikel;

    public KommentarDTO(String text, User user, Artikel artikel) {
        this.text = text;
        this.user = user;
        this.artikel = artikel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }
}
