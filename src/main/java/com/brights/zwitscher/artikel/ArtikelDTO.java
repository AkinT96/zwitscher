package com.brights.zwitscher.artikel;

import java.time.LocalDateTime;

public class ArtikelDTO {
    private String titel;
    private String text;
    private String url;
    private LocalDateTime erstelltAm;

    public ArtikelDTO(String titel, String text, String url, LocalDateTime erstelltAm) {
        this.titel = titel;
        this.text = text;
        this.url = url;
        this.erstelltAm = erstelltAm;
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
}
