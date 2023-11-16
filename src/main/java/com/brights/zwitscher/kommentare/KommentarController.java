package com.brights.zwitscher.kommentare;
import com.brights.zwitscher.artikel.Artikel;
import com.brights.zwitscher.artikel.ArtikelRepository;
import com.brights.zwitscher.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


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

        Optional<Artikel> artikel = artikelRepository.findById(artikelId);
        List<Kommentar> kommentarListe = kommentarRepository.findByArtikelOrderByErstelltAmAsc(artikel);
        return new KommentarListeDTO(kommentarListe);
    }

    @PostMapping("/pluskommentar")
    public Kommentar kommentarHinzufügen (@ModelAttribute("sessionUser") Optional<User> sessionUserOptional,
                                          @RequestBody KommentarDTO kommentar){
        User sessionUser = sessionUserOptional
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Logindaten sind nicht gültig."));

        return kommentarRepository.save(new Kommentar(kommentar.getText(), kommentar.getUser(), kommentar.getArtikel()));


    }
}
