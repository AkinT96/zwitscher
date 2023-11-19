package com.brights.zwitscher.kommentare;
import com.brights.zwitscher.artikel.Artikel;
import com.brights.zwitscher.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Kommentar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    private User user;

   // @JsonBackReference
    @ManyToOne
    private Artikel artikel;

    @CreationTimestamp
    @Column(name ="erstelltAm", nullable = false,updatable = false)
    private LocalDateTime erstelltAm;

    public Kommentar(){

    }

    public Kommentar(String text, User user, Artikel artikel) {
        this.artikel = artikel;
        this.text = text;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getErstelltAm() {
        return erstelltAm;
    }

    public void setErstelltAm(LocalDateTime erstelltAm) {
        this.erstelltAm = erstelltAm;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }
}
