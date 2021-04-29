package com.edu.colegio.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.colegio.apirest.model.Estudiante;
import com.edu.colegio.apirest.service.EstudianteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author JUAN DAVID GARCIA
 *
 */
@RestController
@RequestMapping("/estudiante")
@Api("Api CRUD para Estudiante")
public class EstudianteController {
	
	private final EstudianteService estudianteService;
	
	/**
	 * @param cursoService
	 */
	@Autowired
	public EstudianteController(EstudianteService estudianteService) {
		this.estudianteService = estudianteService;
	}
	
	@ApiOperation(value = "Metodo para guardar el registro del estudiante")
	@PostMapping("/save")
	public void saveEstudiante(@Validated @RequestBody Estudiante estudianteModel) {
		estudianteService.saveEstudiante(estudianteModel);
	}
	
	@ApiOperation(value = "Metodo para actualizar el registro del estudiante")
	@PutMapping("/update/{idEstudiante}")
	public void updateProfesor(@Validated @RequestBody Estudiante estudianteModel,
			@PathVariable Long idEstudiante) {		
		if(estudianteModel != null) {
			Estudiante estudiante = estudianteService.findEstudianteById(idEstudiante);
			if(estudiante != null) {
				estudiante.setId(idEstudiante);
				estudiante.setNombre(estudianteModel.getNombre());
				
				estudianteService.saveEstudiante(estudiante);
			}
		}
	}
	
	@ApiOperation(value = "Metodo para eliminar el registro del estudiante")
	@DeleteMapping("/delete/{idEstudiante}")
	public void deleteEstudiante(@PathVariable Long idEstudiante) {
		if(idEstudiante != null) {
			estudianteService.deleteEstudiante(idEstudiante);
		}
	}
	
	@ApiOperation(value = "Metodo para consultar todos los regsitros del estudiante")
	@GetMapping("/all")
	public List<Estudiante> findEstudianteAll(){
		List<Estudiante> estudianteList = estudianteService.findEstudianteAll();
		return estudianteList;
	}
	
	@ApiOperation(value = "Metodo para consultar el registro del estudiante por el id")
	@GetMapping("/{idEstudiante}")
	public Estudiante findEstudianteById(@PathVariable Long idEstudiante) {
		Estudiante objEstudiante = null;
		
		if(idEstudiante != null) {
			objEstudiante = estudianteService.findEstudianteById(idEstudiante);
		}
		return objEstudiante;
	}
}
