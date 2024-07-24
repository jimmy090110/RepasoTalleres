package com.edu.uce.pw.api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.uce.pw.api.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Estudiante seleccionar(String cedula) {
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createQuery("SELECT e from Estudiante e WHERE e.cedula =: cedula", Estudiante.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public void eliminar(String cedula) {
		this.entityManager.remove(this.seleccionar(cedula));

	}

	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);

	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.entityManager.merge(estudiante);

	}

	@Override
	public List<Estudiante> seleccionarTodos() {
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e from Estudiante e ",
				Estudiante.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> seleccionarPorGenero(String genero) {
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createQuery("SELECT e from Estudiante e WHERE e.genero=:genero ", Estudiante.class);
		myQuery.setParameter("genero", genero);
		return myQuery.getResultList();
	}

}
