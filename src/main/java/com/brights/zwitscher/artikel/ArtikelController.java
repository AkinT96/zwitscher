package com.brights.zwitscher.artikel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class ArtikelController {

    private ArtikelRepository artikelRepository;

    @Autowired
    public ArtikelController(ArtikelRepository artikelRepository) {
        this.artikelRepository = artikelRepository;
    }

    @GetMapping("/posts")
    public ArtikelListeDTO artikelausgeben() {
        List<Artikel> artikelListe = artikelRepository.findAllByOrderByErstelltAmDesc();
        return new ArtikelListeDTO(artikelListe);
    }
}
