package com.brights.zwitscher.artikel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ArtikelRepository  extends JpaRepository<Artikel, Long> {

    List<Artikel> findAllByOrderByErstelltAmDesc();

}
