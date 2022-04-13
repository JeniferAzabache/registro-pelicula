package com.jenifera.registropeliculas.app.services;

import com.jenifera.registropeliculas.app.documents.Genero;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface GeneroService {
	
	public Flux<Genero> findAll();
	
	public Mono<Genero> findById(String id);
		
	public Mono<Genero> save(Genero genero);
	
	public Mono<Void> delete(Genero genero);
	

}
