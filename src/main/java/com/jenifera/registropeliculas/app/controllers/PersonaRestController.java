package com.jenifera.registropeliculas.app.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.jenifera.registropeliculas.app.documents.Persona;

import com.jenifera.registropeliculas.app.services.imp.PersonaServiceImp;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/persona")
public class PersonaRestController {

	@Autowired
	private PersonaServiceImp personaServiceImp;
	
	@GetMapping()
	public Flux<Persona> index(){
		Flux<Persona> flux=personaServiceImp.findAll();
		return flux;
	}
	
	@PostMapping("/guardar")
	public Mono<Persona> save(@RequestBody Persona persona){
		persona.setActualizacion(new Date());
		Mono<Persona> mono=personaServiceImp.save(persona);
		return mono;
		
	}
	
	@GetMapping("/{id}")
	public Mono<Persona> buscarId(@PathVariable String id){
		Mono<Persona> buscar= personaServiceImp.findById(id);
		return buscar;
	}
	
	@DeleteMapping("/delete")
	public Mono<String> delete(@RequestBody Persona persona){
		return personaServiceImp.findById(persona.getId())
				.defaultIfEmpty(new Persona())
				
				.flatMap(g-> g.getId()==null ? Mono.error(new InterruptedException("No existe la persona")):
					personaServiceImp.delete(persona) )
				.then(Mono.just("Eliminado con exito"))
				.onErrorResume(ex -> Mono.just("Error al eliminar"));	
				
	}
}
