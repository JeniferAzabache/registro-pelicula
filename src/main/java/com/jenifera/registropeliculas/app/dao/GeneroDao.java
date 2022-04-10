package com.jenifera.registropeliculas.app.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.jenifera.registropeliculas.app.documents.Genero;

public interface GeneroDao extends ReactiveMongoRepository<Genero, String> {

}
