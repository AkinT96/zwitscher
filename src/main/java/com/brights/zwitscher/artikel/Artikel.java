package com.brights.zwitscher.artikel;

import com.brights.zwitscher.kommentare.Kommentar;
import com.brights.zwitscher.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Entity
public class Artikel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User user;

    private String titel;
    @Column(columnDefinition="TEXT")
    private String text;
    @Column(columnDefinition="TEXT")
    private String url;
    @OneToMany(mappedBy = "artikel")
    //@OrderBy("erstelltAm ASC")
    private List<Kommentar> kommentare;
    @CreationTimestamp
    @Column(name ="erstelltAm", nullable = false,updatable = false)
    private LocalDateTime erstelltAm;

    public Artikel(long id, User user, String titel, String text, String url, LocalDateTime erstelltAm) {
        this.id = id;
        this.user = user;
        this.titel = titel;
        this.text = text;
        this.url = url;
        this.erstelltAm = erstelltAm;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getErstelltAm() {
        return erstelltAm;
    }

    public void setErstelltAm(LocalDateTime erstelltAm) {
        this.erstelltAm = erstelltAm;
    }

    public Artikel() {

    }
}
