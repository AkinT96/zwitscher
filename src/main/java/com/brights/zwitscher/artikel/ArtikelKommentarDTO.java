package com.brights.zwitscher.artikel;

import com.brights.zwitscher.kommentare.Kommentar;
import com.brights.zwitscher.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ArtikelKommentarDTO {
    private Long id;
    private String text;
    private String titel;
    private String url;
    private User user;
    private LocalDateTime erstelltAm;
    private List<Kommentar> kommentare;

    public ArtikelKommentarDTO(Long id, String text, String titel, String url, User user, LocalDateTime erstelltAm) {
        this.id = id;
        this.text = text;
        this.titel = titel;
        this.url = url;
        this.user = user;
        this.erstelltAm = erstelltAm;

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

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
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

    public List<Kommentar> getKommentare() {
        return kommentare;
    }

    public void setKommentare(List<Kommentar> kommentare) {
        this.kommentare = kommentare;
    }
}
