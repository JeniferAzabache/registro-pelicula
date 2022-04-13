package com.jenifera.registropeliculas.app.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jenifera.registropeliculas.app.dao.PeliculaDao;
import com.jenifera.registropeliculas.app.documents.Pelicula;
import com.jenifera.registropeliculas.app.services.PeliculaService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PeliculaServiceImp implements PeliculaService{

	@Autowired
	private PeliculaDao peliculaDao;
	
	@Override
	public Flux<Pelicula> findAll() {
		
		return peliculaDao.findAll();
	}

	@Override
	public Mono<Pelicula> findById(String id) {
		
		return peliculaDao.findById(id);
	}

	@Override
	public Mono<Pelicula> save(Pelicula pelicula) {
		
		return peliculaDao.save(pelicula);
	}

	@Override
	public Mono<Void> delete(Pelicula pelicula) {
		
		return peliculaDao.delete(pelicula);
	}

}
