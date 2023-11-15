package com.brights.zwitscher.artikel;

import java.util.List;

public class ArtikelListeDTO {

    private List<Artikel> artikelListe;

    public ArtikelListeDTO(List<Artikel> artikelListe) {
        this.artikelListe = artikelListe;
    }

    public List<Artikel> getArtikelListe() {
        return artikelListe;
    }

    public void setArtikelListe(List<Artikel> artikelListe) {
        this.artikelListe = artikelListe;
    }
}
