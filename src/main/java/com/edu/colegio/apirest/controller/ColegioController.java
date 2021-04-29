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

import com.edu.colegio.apirest.model.Colegio;
import com.edu.colegio.apirest.service.ColegioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author JUAN DAVID GARCIA
 *
 */
@RestController
@RequestMapping("/colegio")
@Api("Api CRUD para Colegio")
public class ColegioController {
	
	private final ColegioService colegioService;

	/**
	 * @param colegioService
	 */
	@Autowired
	public ColegioController(ColegioService colegioService) {
		this.colegioService = colegioService;
	}	
	
	@ApiOperation(value = "Metodo para guardar el registro del colegio")
	@PostMapping("/save")
	public void saveColegio(@Validated @RequestBody Colegio colegioModel) {
		colegioService.saveColegio(colegioModel);
	}
	
	@ApiOperation(value = "Metodo para eliminar el registro del colegio")
	@DeleteMapping("/delete/{idColegio}")
	public void deleteColegio(@PathVariable Long idColegio) {
		if(idColegio != null) {
			colegioService.deleteColegio(idColegio);
		}
	}
	
	@ApiOperation(value = "Metodo para consultar todos los regsitros del colegio")
	@GetMapping("/all")
	public List<Colegio> findColegioAll(){
		List<Colegio> colegioList = colegioService.findColegioAll();
		return colegioList;
	}
	
	@ApiOperation(value = "Metodo para consultar el registro del colegio por el id")
	@GetMapping("/{idColegio}")
	public Colegio findColegioById(@PathVariable Long idColegio) {
		Colegio objColegio = null;
		
		if(idColegio != null) {
			objColegio = colegioService.findColegioById(idColegio);
		}
		return objColegio;
	}
}
