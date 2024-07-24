package com.edu.uce.pw.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.api.service.IEstudianteService;
import com.edu.uce.pw.api.service.IMateriaService;
import com.edu.uce.pw.api.service.to.EstudianteTO;
import com.edu.uce.pw.api.service.to.MateriaTO;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

@RestController
@RequestMapping(path = "/estudiantes")
@CrossOrigin(value = "http://localhost:8081")
public class EstudianteController {
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@Autowired
	private IMateriaService materiaService;
	
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/hateoas/1235
	@GetMapping(path = "/hateoas/{cedula}",produces = MediaType.APPLICATION_JSON_VALUE)
	public EstudianteTO buscarHateoas(@PathVariable String cedula) {
			EstudianteTO estu = this.estudianteService.buscar(cedula);
			System.out.println(this.buscarMateraPorIdEstudiante(estu.getId()));
		
			System.out.println("estu: "+estu);
			System.out.println("estu: "+estu.getId());
			Link myLink= linkTo(methodOn(EstudianteController.class).buscarMateraPorIdEstudiante(estu.getId())).withRel("susMaterias");
			estu.add(myLink);
			return estu;
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/1/materias
	@GetMapping(path = "/{id}/materias",produces = MediaType.APPLICATION_JSON_VALUE)
		public List<MateriaTO>buscarMateraPorIdEstudiante(@PathVariable Integer id){
		 List<MateriaTO> m = this.materiaService.buscarPorIdEstudiante(id);
			return  m;
		}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/1234/cedula
	@GetMapping(path = "{cedula}/cedula",produces = MediaType.APPLICATION_JSON_VALUE)
	public EstudianteTO buscarPorCedula(@PathVariable String cedula) {
		return this.estudianteService.buscar(cedula);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void guardar(@RequestBody EstudianteTO estudianteTO) {
		this.estudianteService.registrarTO(estudianteTO);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/1236
	@PutMapping(path = "{cedula}" ,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody EstudianteTO estudianteTO, @PathVariable String cedula) {
		EstudianteTO estudianteEncontrado = this.buscarPorCedula(cedula);
		
		estudianteTO.setCedula(cedula);
		estudianteTO.setId(estudianteEncontrado.getId());
		this.estudianteService.actualizarTO(estudianteTO);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/1235
	@DeleteMapping(path = "/{cedula}")
	public void borrar(@PathVariable String cedula) {
		this.estudianteService.borrar(cedula);
		
	}
	
	
	

	

}
