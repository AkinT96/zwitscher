package com.brights.zwitscher.kommentare;
import com.brights.zwitscher.artikel.Artikel;
import com.brights.zwitscher.artikel.ArtikelRepository;
import com.brights.zwitscher.user.User;
import jakarta.servlet.http.HttpServletResponse;
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

    @PostMapping("/kommentar/{artikelId}")
    public Kommentar kommentarHinzufügen (@ModelAttribute("sessionUser") Optional<User> sessionUserOptional,
                                          @RequestBody KommentarTextDTO kommentar, @PathVariable Long artikelId){
        User sessionUser = sessionUserOptional
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Logindaten sind nicht gültig."));
        Artikel artikel = artikelRepository.findById(artikelId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Der Artikel existiert nicht"));
        return kommentarRepository.save(new Kommentar(kommentar.getText(), sessionUser, artikel));
    }

    @DeleteMapping("/kommentar/{kommentarId}")
    public void löscheKommentar (@ModelAttribute("sessionUser") Optional<User> sessionUserOptional,
                                 @PathVariable Long kommentarId, HttpServletResponse response){
        User sessionUser = sessionUserOptional
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Logindaten sind nicht gültig."));
        Kommentar kommentar = kommentarRepository.findById(kommentarId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Der Kommentar existiert nicht."));
        if (kommentar.getUser().equals(sessionUser) || sessionUser.isAdmin()){
            kommentarRepository.delete(kommentar);
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
        else{
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Du hast keine Rechte den Kommentar zu löschen");
        }
    }
}