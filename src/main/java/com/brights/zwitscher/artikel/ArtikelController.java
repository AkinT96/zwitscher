package com.brights.zwitscher.artikel;

import com.brights.zwitscher.user.User;
import com.brights.zwitscher.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class ArtikelController {

    private ArtikelRepository artikelRepository;
    private UserRepository userRepository;

    @Autowired
    public ArtikelController(ArtikelRepository artikelRepository, UserRepository userRepository) {
        this.artikelRepository = artikelRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/artikelliste")
    public ArtikelListeDTO artikelAusgeben() {
        List<Artikel> artikelListe = artikelRepository.findAllByOrderByErstelltAmDesc();
        return new ArtikelListeDTO(artikelListe);
    }

    @PostMapping("/artikel")
    public Artikel artikelErstellen(@RequestBody ArtikelDTO artikelDTO, @ModelAttribute("sessionUser") Optional<User> sessionUserOptional) {


        User user = sessionUserOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Logindaten sind nicht gültig."));

        if (!user.isAdmin()) throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Du bist kein Admin");

        else {
            Artikel artikel = new Artikel();
            artikel.setUser(user);
            artikel.setTitel(artikelDTO.getTitel());
            artikel.setUrl(artikelDTO.getUrl());
            artikel.setText(artikelDTO.getText());
            return artikelRepository.save(artikel);

        }
    }

    @PutMapping("/artikel/{artikelId}")
    public Artikel artikelBearbeiten(@RequestBody ArtikelDTO artikelDTO, @PathVariable Long artikelId,
                                     @ModelAttribute("sessionUser") Optional<User> sessionUserOptional){
        User user = sessionUserOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Logindaten sind nicht gültig."));
        if (!user.isAdmin()) throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Du bist kein Admin");
        Artikel artikel = artikelRepository.findById(artikelId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Der Artikel existiert nicht"));
        artikel.setText(artikelDTO.getText());
        artikel.setTitel(artikelDTO.getTitel());
        artikel.setUrl(artikelDTO.getUrl());
        return artikelRepository.save(artikel);

    }
}
