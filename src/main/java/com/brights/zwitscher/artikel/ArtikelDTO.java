package com.brights.zwitscher.artikel;

import java.time.LocalDateTime;

public class ArtikelDTO {
    private String titel;
    private String text;
    private String url;

    public ArtikelDTO(String titel, String text, String url) {
        this.titel = titel;
        this.text = text;
        this.url = url;
    }
    public ArtikelDTO(){}

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

}
