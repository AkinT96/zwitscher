package com.brights.zwitscher.artikel;

import com.brights.zwitscher.user.User;
import com.brights.zwitscher.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class KommentarController {
    @Autowired
    private KommentarRepository kommentarRepository;

    @Autowired
    private ArtikelRepository artikelRepository;
    @GetMapping("/kommentare/{artikelId}")
    public KommentarListeDTO kommentareAusgeben (@PathVariable Long artikelId){
        Optional<Artikel> artikel = artikelRepository.findById(artikelId); // Warum ???
        List<Kommentar> kommentarListe = kommentarRepository.findKommentarsByArtikel(artikel);
        return new KommentarListeDTO(kommentarListe);

    }
}
