package com.jenifera.registropeliculas.app.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jenifera.registropeliculas.app.dao.GeneroDao;
import com.jenifera.registropeliculas.app.documents.Genero;
import com.jenifera.registropeliculas.app.services.GeneroService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GeneroServiceImp implements GeneroService {

	@Autowired
	private GeneroDao generoDao;
	
	
	@Override
	public Flux<Genero> findAll() {
		
		return generoDao.findAll();
	}

	@Override
	public Mono<Genero> findById(String id) {
		
		return generoDao.findById(id);
	}

	@Override
	public Mono<Genero> save(Genero genero) {
		
		return generoDao.save(genero);
	}

	@Override
	public Mono<Void> delete(Genero genero) {
		
		 return generoDao.delete(genero) ;
	}

}
