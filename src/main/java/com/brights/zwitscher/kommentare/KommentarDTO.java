package com.brights.zwitscher.kommentare;
import com.brights.zwitscher.artikel.Artikel;
import com.brights.zwitscher.user.User;

public class KommentarDTO {
    private String text;

    private Artikel artikel;

    public KommentarDTO(String text, Artikel artikel) {
        this.text = text;
        this.artikel = artikel;
        }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }
}
