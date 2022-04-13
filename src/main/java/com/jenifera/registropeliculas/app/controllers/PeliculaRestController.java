package com.jenifera.registropeliculas.app.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jenifera.registropeliculas.app.documents.Genero;
import com.jenifera.registropeliculas.app.documents.Pelicula;
import com.jenifera.registropeliculas.app.documents.Persona;
import com.jenifera.registropeliculas.app.services.imp.PeliculaServiceImp;
import com.jenifera.registropeliculas.app.services.imp.PersonaServiceImp;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/pelicula")
public class PeliculaRestController {
	
	@Autowired
	private PeliculaServiceImp peliculaServiceImp;
	
	@Autowired
	private PersonaServiceImp personaServiceImp;
	
	@GetMapping()
	public Flux<Pelicula> index(){
		Flux<Pelicula> flux=peliculaServiceImp.findAll();
		return flux;
	}
	
	@PostMapping("/guardar")
	public Mono<Pelicula> save(@RequestBody Pelicula pelicula){
		
		List<String> ma = new ArrayList<>();
		List<String> md = new ArrayList<>();
		List<String> mg = new ArrayList<>();
		
		for (String a : pelicula.getActores()) {
			ma.add("http://localhost:8080/api/persona/"+a);
		}
		for (String a : pelicula.getDirectores()) {
			md.add("http://localhost:8080/api/persona/"+a);
		}
		for (String a : pelicula.getGeneros()) {
			mg.add("http://localhost:8080/api/genero/"+a);
		}
		
		pelicula.setActores(ma);
		pelicula.setDirectores(md);
		pelicula.setGeneros(mg);
		pelicula.setUtilidades(pelicula.getDineroRecaudado()-pelicula.getPresupuesto());
		Mono<Pelicula> mono=peliculaServiceImp.save(pelicula);
		return mono;
	}
	
	@GetMapping("/{id}")
	public Mono<Pelicula> buscarId(@PathVariable String id){
		Mono<Pelicula> buscar= peliculaServiceImp.findById(id);
		return buscar;
	}
	
	@DeleteMapping("/delete")	
	public Mono<String> delete(@RequestBody Pelicula pelicula){
		return peliculaServiceImp.findById(pelicula.getId())
		.defaultIfEmpty(new Pelicula())
		.flatMap(g-> g.getId()==null ? Mono.error(new InterruptedException("No existe la pelicula")):
			peliculaServiceImp.delete(pelicula))
			.then(Mono.just("Eliminado exitosamente"))
			.onErrorResume(ex -> Mono.just("Error al eliminar"));
	
	}
}
