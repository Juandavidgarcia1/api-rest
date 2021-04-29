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

import com.edu.colegio.apirest.model.Curso;
import com.edu.colegio.apirest.service.CursoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author JUAN DAVID GARCIA
 *
 */
@RestController
@RequestMapping("/curso")
@Api("Api CRUD para Curso")
public class CursoController {
	
	private final CursoService cursoService;

	/**
	 * @param cursoService
	 */
	@Autowired
	public CursoController(CursoService cursoService) {
		this.cursoService = cursoService;
	}
	
	@ApiOperation(value = "Metodo para guardar el registro del curso")
	@PostMapping("/save")
	public void saveCurso(@Validated @RequestBody Curso cursoModel) {
		cursoService.saveCurso(cursoModel);
	}
	
	@ApiOperation(value = "Metodo para eliminar el registro del curso")
	@DeleteMapping("/delete/{idCurso}")
	public void deleteCurso(@PathVariable Long idCurso) {
		if(idCurso != null) {
			cursoService.deleteCurso(idCurso);
		}
	}
	
	@ApiOperation(value = "Metodo para consultar todos los regsitros del curso")
	@GetMapping("/all")
	public List<Curso> findColegioAll(){
		List<Curso> cursoList = cursoService.findCursoAll();
		return cursoList;
	}
	
	@ApiOperation(value = "Metodo para consultar el registro del curso por el id")
	@GetMapping("/{idCurso}")
	public Curso findCursoById(@PathVariable Long idCurso) {
		Curso objCurso = null;
		
		if(idCurso != null) {
			objCurso = cursoService.findCursoById(idCurso);
		}
		return objCurso;
	}
}
