package com.jenifera.registropeliculas.app.documents;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "generos")
public class Genero {
	
	@Id
	private String id;
	
	private String nombre;
	
	private String descripcion;
	
	private Date actualizacion;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getActualizacion() {
		return actualizacion;
	}

	public void setActualizacion(Date actualizacion) {
		this.actualizacion = actualizacion;
	}

	public Genero(String nombre, String descripcion) {
		
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Genero() {
		
	}
	

}
