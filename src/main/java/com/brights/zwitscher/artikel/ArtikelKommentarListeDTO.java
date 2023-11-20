package com.brights.zwitscher.artikel;

import java.util.List;

public class ArtikelKommentarListeDTO {
    private List<ArtikelKommentarDTO> artikelKommentarListe;

    public ArtikelKommentarListeDTO(List<ArtikelKommentarDTO> artikelKommentarListe) {
        this.artikelKommentarListe = artikelKommentarListe;
    }

    public List<ArtikelKommentarDTO> getArtikelKommentarListe() {
        return artikelKommentarListe;
    }

    public void setArtikelKommentarListe(List<ArtikelKommentarDTO> artikelKommentarListe) {
        this.artikelKommentarListe = artikelKommentarListe;
    }
}
