package com.jenifera.registropeliculas.app.services;

import com.jenifera.registropeliculas.app.documents.Pelicula;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PeliculaService {
	
	public Flux<Pelicula> findAll();
	
	public Mono<Pelicula> findById(String id);
		
	public Mono<Pelicula> save(Pelicula pelicula);
	
	public Mono<Void> delete(Pelicula pelicula);
	
}
