package com.edu.uce.pw.api.repository;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Estudiante;

public interface IEstudianteRepository {
	
	public  Estudiante seleccionar(String cedula);
	public void eliminar(String cedula);
	public void insertar(Estudiante estudiante);
	public  void actualizar(Estudiante estudiante);
	List<Estudiante> seleccionarTodos();
	List<Estudiante>seleccionarPorGenero(String genero);

}
