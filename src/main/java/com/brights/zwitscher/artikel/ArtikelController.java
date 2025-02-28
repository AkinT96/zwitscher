package com.brights.zwitscher.artikel;

import com.brights.zwitscher.kommentare.KommentarRepository;
import com.brights.zwitscher.user.User;
import com.brights.zwitscher.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ArtikelController {

    private ArtikelRepository artikelRepository;
    private UserRepository userRepository;
    private KommentarRepository kommentarRepository;

    @Autowired
    public ArtikelController(ArtikelRepository artikelRepository, UserRepository userRepository, KommentarRepository kommentarRepository) {
        this.artikelRepository = artikelRepository;
        this.userRepository = userRepository;
        this.kommentarRepository = kommentarRepository;
    }

    @GetMapping("/artikel/{artikelId}")
    public Artikel artikelAusgeben(@PathVariable Long artikelId, @ModelAttribute("sessionUser") Optional<User> sessionUserOptional) {
        User user = sessionUserOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Logindaten sind nicht gültig."));
        return artikelRepository.findById(artikelId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Artikel nicht gefunden"));
    }

    @GetMapping("/artikelliste")
    public ArtikelListeDTO artikelListeAusgeben(@ModelAttribute("sessionUser") Optional<User> sessionUserOptional) {
        User user = sessionUserOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Logindaten sind nicht gültig."));
        List<Artikel> artikelListe = artikelRepository.findAllByOrderByErstelltAmDesc();
        return new ArtikelListeDTO(artikelListe);
    }

    @GetMapping("/artikelkommentarliste")
    public ArtikelKommentarListeDTO artikelKommentarListeAusgeben(@ModelAttribute("sessionUser") Optional<User> sessionUserOptional) {
        User user = sessionUserOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Logindaten sind nicht gültig."));
        List<Artikel> artikelListe = artikelRepository.findAllByOrderByErstelltAmDesc();
        List<ArtikelKommentarDTO> artikelKommentareListe = new ArrayList<>();

        for (Artikel artikel : artikelListe){
           ZonedDateTime zonedDateTime = ZonedDateTime.of(artikel.getErstelltAm(), ZoneId.of("Europe/Berlin"));
           String zeit = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(zonedDateTime);
           ArtikelKommentarDTO artikelKommentar= new ArtikelKommentarDTO(artikel.getId(), artikel.getText(),
                   artikel.getTitel(), artikel.getUrl(), artikel.getUser(), zeit);
           artikelKommentar.setKommentare(kommentarRepository.findByArtikelOrderByErstelltAmAsc(Optional.ofNullable(artikel)));
           artikelKommentareListe.add(artikelKommentar);
        }
        return new ArtikelKommentarListeDTO(artikelKommentareListe);
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
    public Artikel artikelBearbeiten(@RequestBody ArtikelDTO artikelDTO, @PathVariable Long artikelId, @ModelAttribute("sessionUser") Optional<User> sessionUserOptional) {
        User user = sessionUserOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Logindaten sind nicht gültig."));
        if (!user.isAdmin()) throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Du bist kein Admin");
        Artikel artikel = artikelRepository.findById(artikelId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Der Artikel existiert nicht"));
        artikel.setText(artikelDTO.getText());
        artikel.setTitel(artikelDTO.getTitel());
        artikel.setUrl(artikelDTO.getUrl());
        return artikelRepository.save(artikel);

    }
}