package com.edu.uce.pw.api.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;


public class MateriaTO extends RepresentationModel<MateriaTO> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4539012581035404368L;
	
	private Integer id;
	
	private Integer creditos;

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

	@Override
	public String toString() {
		return "MateriaTO [id=" + id + ", creditos=" + creditos + "]";
	}
	
	

	
	
	

}
