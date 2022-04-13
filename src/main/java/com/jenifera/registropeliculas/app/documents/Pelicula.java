package com.jenifera.registropeliculas.app.documents;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "peliculas")
public class Pelicula {
	
	@Id
	private String id;
	
	private String nombre;

	private Date fechaEstreno;
	
	private String duracion;
	
	private String clasificacion;
	
	private double presupuesto;
	
	private double dineroRecaudado;
	
	private double utilidades;
	
	private double puntuacion;
	
	@Valid
	private List<String> actores = new ArrayList<>();
	
	@Valid
	private List<String> directores = new ArrayList<>();
	
	@Valid
	private List<String> generos = new ArrayList<>();

	
	public Pelicula(String nombre, Date fechaEstreno, String duracion, String clasificacion, double presupuesto,
			double dineroRecaudado, double puntuacion, @Valid List<String> actores, @Valid List<String> directores,
			@Valid List<String> generos) {
		
		this.nombre=nombre;
		this.fechaEstreno = fechaEstreno;
		this.duracion = duracion;
		this.clasificacion = clasificacion;
		this.presupuesto = presupuesto;
		this.dineroRecaudado = dineroRecaudado;
		this.puntuacion = puntuacion;
		this.actores = actores;
		this.directores = directores;
		this.generos = generos;
	}

	
	
}
