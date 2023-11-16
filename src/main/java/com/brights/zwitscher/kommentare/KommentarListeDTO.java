package com.brights.zwitscher.kommentare;
import java.util.List;

public class KommentarListeDTO {
    private List<Kommentar> kommentarListe;

    public KommentarListeDTO(List<Kommentar> kommentarListe) {
        this.kommentarListe = kommentarListe;
    }

    public List<Kommentar> getKommentarListe() {
        return kommentarListe;
    }

    public void setKommentarListe(List<Kommentar> kommentarListe) {
        this.kommentarListe = kommentarListe;
    }
}
