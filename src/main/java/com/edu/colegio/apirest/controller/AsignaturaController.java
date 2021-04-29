/**
 * 
 */
package com.edu.colegio.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.colegio.apirest.model.Asignatura;
import com.edu.colegio.apirest.service.AsignaturaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author JUAN DAVID GARCIA
 *
 */
@RestController
@RequestMapping("/asignatura")
@Api("Api CRUD para Asignatura")
public class AsignaturaController {
	
	private final AsignaturaService asignaturaService;

	/**
	 * @param asignaturaService
	 */
	@Autowired
	public AsignaturaController(AsignaturaService asignaturaService) {
		this.asignaturaService = asignaturaService;
	}
	
	@ApiOperation(value = "Metodo para guardar el registro de la asignatuta")
	@PostMapping(path = "/save")
	public void saveAsignatura(@Validated @RequestBody Asignatura asignaturaModel) {
		asignaturaService.saveAsignatura(asignaturaModel);
	}
	
	@ApiOperation(value = "Metodo para eliminar el registro de la asignatuta")
	@DeleteMapping(name = "/delete/{idAsignatura}")
	public void deleteAsignatura(@PathVariable Long idAsignatura) {
		if(idAsignatura != null) {
			asignaturaService.deleteAsignatura(idAsignatura);
		}
	}
	
	@ApiOperation(value = "Metodo para consultar todos los registros de la asignatuta")
	@GetMapping(path = "/all")
	public List<Asignatura> findAsignaturaAll(){
		List<Asignatura> asignaturaList = asignaturaService.findAsignaturaAll();
		return asignaturaList;
	}
	
	@ApiOperation(value = "Metodo para consultar todos los registros de la asignatuta por el id")
	@GetMapping(path = "/{idAsignatura}")
	public Asignatura findAsignaturaById(@PathVariable Long idAsignatura) {
		Asignatura objAsignatura= null;
		
		if(idAsignatura != null) {
			objAsignatura = asignaturaService.findAsignaturaById(idAsignatura);
		}
		return objAsignatura;
	}
}
