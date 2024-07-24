package com.edu.uce.pw.api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.uce.pw.api.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class MateriaRepositoryImpl implements IMateriaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Materia seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Materia.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.seleccionar(id));
		
	}

	@Override
	public void actualizar(Materia materia) {
		this.entityManager.merge(materia);
		
	}

	@Override
	public void insertar(Materia materia) {
		this.entityManager.persist(materia);	
	}

	@Override
	public List<Materia> seleccionarPorIdEstudiante(Integer id) {
System.out.println("askdflkasdnfksjdkfjsdlkf: "+id);
		TypedQuery<Materia>myQuery=this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.estudiante.id=:id",Materia.class);
		myQuery.setParameter("id", id);
		List<Materia> mtes=myQuery.getResultList();
		System.out.println("MATERIAS EN REPO: "+mtes);
		
		return mtes;
	}

}
