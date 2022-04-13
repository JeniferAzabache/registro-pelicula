package com.jenifera.registropeliculas.app.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jenifera.registropeliculas.app.dao.PersonaDao;
import com.jenifera.registropeliculas.app.documents.Persona;
import com.jenifera.registropeliculas.app.services.PersonaService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonaServiceImp implements PersonaService {

	@Autowired
	private PersonaDao personaDao;
	
	@Override
	public Flux<Persona> findAll() {
		
		return personaDao.findAll();
	}

	@Override
	public Mono<Persona> findById(String id) {
		
		return personaDao.findById(id);
	}

	@Override
	public Mono<Persona> save(Persona persona) {
		
		return personaDao.save(persona);
	}

	@Override
	public Mono<Void> delete(Persona persona) {
		
		return personaDao.delete(persona);
	}

}
