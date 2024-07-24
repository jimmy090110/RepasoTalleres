package com.edu.uce.pw.api.repository.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name ="materia")
//@JsonIgnoreProperties(value = "estudiante")
public class Materia {
	
	@Id
	@GeneratedValue(generator = "seq_materia", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
	@Column(name = "mtra_id")
	private Integer id;
	
	@Column(name = "mtra_creditos")
	private Integer creditos;
	
	
	@ManyToOne
	@JoinColumn(name ="materia_id_estudiante")
	private Estudiante estudiante;


	@Override
	public String toString() {
		return "Materia [id=" + id + ", creditos=" + creditos + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getCreditos() {
		return creditos;
	}


	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}


	public Estudiante getEstudiante() {
		return estudiante;
	}


	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}


	

}
