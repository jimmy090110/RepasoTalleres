package com.edu.uce.pw.api.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;


public class EstudianteTO extends RepresentationModel<EstudianteTO> implements Serializable {

	
	private static final long serialVersionUID = 5806153784200382533L;
	
	private Integer id;
	
	private String nombre;
	
	   
	    private String apellido;

	    
	    private LocalDateTime fechaNacimiento;

	  
	    private String genero;
	    
	  
	    private String cedula;


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public String getApellido() {
			return apellido;
		}


		public void setApellido(String apellido) {
			this.apellido = apellido;
		}


		public LocalDateTime getFechaNacimiento() {
			return fechaNacimiento;
		}


		public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}


		public String getGenero() {
			return genero;
		}


		public void setGenero(String genero) {
			this.genero = genero;
		}


		public String getCedula() {
			return cedula;
		}


		public void setCedula(String cedula) {
			this.cedula = cedula;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		@Override
		public String toString() {
			return "EstudianteTO [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
					+ fechaNacimiento + ", genero=" + genero + ", cedula=" + cedula + "]";
		}
	    
		
		
	    
	

}
