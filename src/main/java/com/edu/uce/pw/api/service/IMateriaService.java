package com.edu.uce.pw.api.service;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.to.MateriaTO;

public interface IMateriaService {
	void agregar(MateriaTO materiaTO);
	void modificar(MateriaTO materiaTO);
	MateriaTO buscar(Integer id);
	void borrar(Integer id);
	public List<MateriaTO> buscarPorIdEstudiante(Integer id);
	

}
