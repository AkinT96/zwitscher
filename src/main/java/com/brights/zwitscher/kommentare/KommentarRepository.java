package com.brights.zwitscher.kommentare;

import com.brights.zwitscher.artikel.Artikel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KommentarRepository extends CrudRepository<Kommentar, Long> {
    List<Kommentar> findByArtikelOrderByErstelltAmAsc(Optional<Artikel> artikel);

}
