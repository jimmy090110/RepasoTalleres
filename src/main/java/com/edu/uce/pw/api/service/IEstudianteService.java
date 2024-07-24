package com.edu.uce.pw.api.service;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.to.EstudianteTO;

public interface IEstudianteService {
	
	public EstudianteTO buscar(String cedula);
	public void borrar(String cedula);
	public void actualizarTO(EstudianteTO estudianteTO);
	public void registrarTO(EstudianteTO estudianteTO);
	List<EstudianteTO>buscarPorGenero(String genero);
	List<EstudianteTO>buscarTodos();
	
	public void actualizar(Estudiante estudiante);
	public void registrar(Estudiante estudiante);
	
	

}
