/**
 * 
 */
package com.edu.colegio.apirest.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.colegio.apirest.model.Profesor;
import com.edu.colegio.apirest.service.ProfesorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author JEISSON
 *
 */
@RestController
@RequestMapping("/profesor")
@Api("Api CRUD para Profesor")
public class ProfesorController {
	
	private final ProfesorService profesorService;

	/**
	 * @param profesorService
	 */
	public ProfesorController(ProfesorService profesorService) {
		this.profesorService = profesorService;
	}
	
	@ApiOperation(value = "Metodo para guardar el registro del profesor")
	@PostMapping("/save")
	public void saveProfesor(@Validated @RequestBody Profesor profesorModel) {
		profesorService.saveProfesor(profesorModel);
	}
	
	@ApiOperation(value = "Metodo para actualizar el registro del profesor")
	@PutMapping("/update/{idProfesor}")
	public void updateProfesor(@Validated @RequestBody Profesor profesorModel,
			@PathVariable Long idProfesor) {		
		if(idProfesor != null) {
			Profesor profesor = profesorService.findProfesorById(idProfesor);
			if(profesor != null) {
				profesor.setId(idProfesor);
				profesor.setNombre(profesorModel.getNombre());
				
				profesorService.saveProfesor(profesor);
			}
		}
	}
	
	@ApiOperation(value = "Metodo para eliminar el registro del profesor")
	@DeleteMapping("/delete/{idProfesor}")
	public void deleteProfesor(@PathVariable Long idProfesor) {
		if(idProfesor != null) {
			profesorService.deleteProfesor(idProfesor);
		}
	}
	
	@ApiOperation(value = "Metodo para consultar todos los regsitros del profesor")
	@GetMapping("/all")
	public List<Profesor> findProfesorAll(){
		List<Profesor> profesorList = profesorService.findProfesorAll();
		return profesorList;
	}
	
	@ApiOperation(value = "Metodo para consultar el registro del profesor por el id")
	@GetMapping("/{idEstudiante}")
	public Profesor findProfesorById(@PathVariable Long idProfesor) {
		Profesor objProfesor = null;
		
		if(idProfesor != null) {
			objProfesor = profesorService.findProfesorById(idProfesor);
		}
		return objProfesor;
	}
}
