package com.edu.uce.pw.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.pw.api.repository.IMateriaRepository;
import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.to.MateriaTO;

@Service
public class MateriaServiceImpl implements IMateriaService {
	
	@Autowired
	private IMateriaRepository materiaRepository;

	@Override
	public void agregar(MateriaTO materiaTO) {
		Materia mat = this.convertirMateria(materiaTO);
		this.materiaRepository.insertar(mat);
		
	}

	@Override
	public void modificar(MateriaTO materiaTO) {
		Materia mat= this.convertirMateria(materiaTO);
		this.materiaRepository.actualizar(mat);
		
	}

	@Override
	public MateriaTO buscar(Integer id) {
		Materia mat = this.materiaRepository.seleccionar(id);
		return this.convertir(mat);

	}

	@Override
	public void borrar(Integer id) {
		this.materiaRepository.eliminar(id);
	}
	
	
	public MateriaTO convertir(Materia materia) {
		MateriaTO matTO = new MateriaTO();
		matTO.setId(materia.getId());
		matTO.setCreditos(materia.getCreditos());	
		return matTO;
	}
	
	
	
	
	
	
	
	
	public Materia convertirMateria(MateriaTO materiaTO) {
		
		Materia mat = new Materia();
		
		mat.setId(materiaTO.getId());
		mat.setCreditos(materiaTO.getCreditos());
		return mat;
		
	}
	
	
	
	
	
	

	@Override
	public List<MateriaTO> buscarPorIdEstudiante(Integer id) {
		List<Materia> materias = this.materiaRepository.seleccionarPorIdEstudiante(id);
		List<MateriaTO>listaF= new ArrayList<>();
			
		for (Materia mat : materias) {
		
		MateriaTO matTO=this.convertir(mat);
			listaF.add(matTO);
			
		}
		return listaF;
	}
	
	

}
