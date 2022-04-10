package com.jenifera.registropeliculas.app.documents;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "peliculas")
public class Pelicula {
	
	@Id
	private String id;

	private Date fechaEstreno;
	
	private String duracion;
	
	private String clasificacion;
	
	private double presupuesto;
	
	private double dineroRecaudado;
	
	private double utilidades;
	
	private double puntuacion;
	
	@Valid
	private Persona actores[];
	
	@Valid
	private Persona directores[];
	
	@Valid
	private Genero generos[];

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public double getDineroRecaudado() {
		return dineroRecaudado;
	}

	public void setDineroRecaudado(double dineroRecaudado) {
		this.dineroRecaudado = dineroRecaudado;
	}

	public double getUtilidades() {
		return utilidades;
	}

	public void setUtilidades(double utilidades) {
		this.utilidades = utilidades;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Persona[] getActores() {
		return actores;
	}

	public void setActores(Persona[] actores) {
		this.actores = actores;
	}

	public Persona[] getDirectores() {
		return directores;
	}

	public void setDirectores(Persona[] directores) {
		this.directores = directores;
	}

	public Genero[] getGeneros() {
		return generos;
	}

	public void setGeneros(Genero[] generos) {
		this.generos = generos;
	}

	public Pelicula(Date fechaEstreno, String duracion, String clasificacion, double presupuesto,
			double dineroRecaudado, double puntuacion, @Valid Persona[] actores, @Valid Persona[] directores,
			@Valid Genero[] generos) {
		
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

	public Pelicula() {
		
	}
	
}
