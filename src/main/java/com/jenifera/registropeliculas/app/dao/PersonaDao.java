package com.jenifera.registropeliculas.app.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.jenifera.registropeliculas.app.documents.Persona;

public interface PersonaDao extends ReactiveMongoRepository<Persona, String>{

}
