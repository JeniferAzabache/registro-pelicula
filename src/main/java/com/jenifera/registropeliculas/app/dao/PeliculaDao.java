package com.jenifera.registropeliculas.app.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.jenifera.registropeliculas.app.documents.Pelicula;

public interface PeliculaDao extends ReactiveMongoRepository<Pelicula, String>{

}
