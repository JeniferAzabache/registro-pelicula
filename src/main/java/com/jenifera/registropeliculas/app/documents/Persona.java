package com.jenifera.registropeliculas.app.documents;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "personas")
public class Persona {
	
	@Id
	private String id;
	
	private String nombre;
	
	private String apellido;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date fechaNac;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date fechaFall;
	
	private Integer edad;
	
	private String nacionalidad;
	
	private Double estatura;
	
	private String foto;
	
	private String genero;
	
	private Date actualizacion;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Date getFechaFall() {
		return fechaFall;
	}

	public void setFechaFall(Date fechaFall) {
		this.fechaFall = fechaFall;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Double getEstatura() {
		return estatura;
	}

	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	
	public Date getActualizacion() {
		return actualizacion;
	}

	public void setActualizacion(Date actualizacion) {
		this.actualizacion = actualizacion;
	}

	public Persona(String nombre, String apellido, Date fechaNac, Date fechaFall, String nacionalidad, Double estatura,
			String foto, String genero) {
	
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.fechaFall = fechaFall;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.foto = foto;
		this.genero = genero;
	}

	public Persona() {
		
	}
	
	
}
