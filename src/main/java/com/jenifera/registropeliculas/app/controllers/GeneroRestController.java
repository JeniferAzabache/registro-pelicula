package com.jenifera.registropeliculas.app.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.jenifera.registropeliculas.app.documents.Genero;
import com.jenifera.registropeliculas.app.services.imp.GeneroServiceImp;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/genero")
public class GeneroRestController {
	
	@Autowired
	private GeneroServiceImp generoServiceImp;
	
	@GetMapping()
	public Flux<Genero> index(){
		Flux<Genero> flux=generoServiceImp.findAll();
		return flux;
	}
	
	@PostMapping("/guardar")
	public Mono<Genero> save(@RequestBody Genero genero){
		genero.setActualizacion(new Date());
		Mono<Genero> mono=generoServiceImp.save(genero);
		return mono;
	}
	
	@GetMapping("/{id}")
	public Mono<Genero> buscarId(@PathVariable String id){
		Mono<Genero> buscar=generoServiceImp.findById(id);
		return buscar;
	}
	
	@DeleteMapping("/delete")
	public Mono<String> delete(@RequestBody Genero genero){
		return generoServiceImp.findById(genero.getId())
				.defaultIfEmpty(new Genero())
				/*.flatMap( g -> {
					if (g.getId() == null) {
						return Mono.error(new InterruptedException("No existe el genero"));
					}
					else {
						
						return generoServiceImp.delete(genero);
				}
				})*/
				.flatMap(g-> g.getId()==null ? Mono.error(new InterruptedException("No existe el genero")):
					generoServiceImp.delete(genero) )
				.then(Mono.just("Eliminado con exito"))
				.onErrorResume(ex -> Mono.just("Error al eliminar"));
	
	}
	

}
