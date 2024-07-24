package com.edu.uce.pw.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.pw.api.repository.IEstudianteRepository;
import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {
	
	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	public EstudianteTO convertir(Estudiante estu) {
		EstudianteTO esTO = new EstudianteTO();
		esTO.setId(estu.getId());
		esTO.setNombre(estu.getNombre());
		esTO.setApellido(estu.getApellido());
		esTO.setFechaNacimiento(estu.getFechaNacimiento());
		esTO.setGenero(estu.getGenero());
		esTO.setCedula(estu.getCedula());
		return esTO;
	}
	
	public Estudiante convertirEstudiante(EstudianteTO estudianteTO) {
		Estudiante estu = new Estudiante();
		estu.setId(estudianteTO.getId());
		estu.setApellido(estudianteTO.getApellido());
		estu.setCedula(estudianteTO.getCedula());
		estu.setGenero(estudianteTO.getGenero());
		estu.setFechaNacimiento(estudianteTO.getFechaNacimiento());
		estu.setNombre(estudianteTO.getNombre());
		
		return estu;
	}

	@Override
	public EstudianteTO buscar(String cedula) {
		Estudiante est = this.estudianteRepository.seleccionar(cedula);
		return this.convertir(est);
	}

	@Override
	public void borrar(String cedula) {
		this.estudianteRepository.eliminar(cedula);
		
		
	}

	@Override
	public void actualizarTO(EstudianteTO estudianteTO) {
		Estudiante e = this.convertirEstudiante(estudianteTO);
		this.estudianteRepository.actualizar(e);
		
		
	}

	@Override
	public void registrarTO(EstudianteTO estudianteTO) {
		Estudiante e = this.convertirEstudiante(estudianteTO);
		this.estudianteRepository.insertar(e);
		
	}

	@Override
	public List<EstudianteTO> buscarPorGenero(String genero) {
		List<Estudiante>estudiantes = this.estudianteRepository.seleccionarPorGenero(genero);
		List<EstudianteTO>estudianteTO= new ArrayList<>();
		for (Estudiante est : estudiantes) {
			estudianteTO.add(this.convertir(est));	
		}
		return null;
	}

	@Override
	public List<EstudianteTO> buscarTodos() {
		List<Estudiante> estudiantes = this.estudianteRepository.seleccionarTodos();
		List<EstudianteTO>estudiantesTO = new ArrayList<>();
		for (Estudiante e : estudiantes) {
			estudiantesTO.add(this.convertir(e));
		}
		return estudiantesTO;
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.estudianteRepository.actualizar(estudiante);
		
	}

	@Override
	public void registrar(Estudiante estudiante) {
		this.estudianteRepository.insertar(estudiante);
		
	}

}
