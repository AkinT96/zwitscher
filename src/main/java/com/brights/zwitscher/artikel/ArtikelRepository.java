package com.brights.zwitscher.artikel;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ArtikelRepository  extends CrudRepository<Artikel, Long> {

    List<Artikel> findAllByOrderByErstelltAmDesc();

}
