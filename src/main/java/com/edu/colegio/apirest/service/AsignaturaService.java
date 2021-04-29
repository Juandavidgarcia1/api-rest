/**
 * 
 */
package com.edu.colegio.apirest.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.colegio.apirest.model.Asignatura;
import com.edu.colegio.apirest.repository.AsignaturaRepository;

import io.swagger.annotations.Api;

/**
 * @author JEISSON
 *
 */
@Service
@Transactional
@Api("Api CRUD para Asignatura")
public class AsignaturaService {
	
	private final AsignaturaRepository asignaturaRepository;

	/**
	 * @param asignaturaRepository
	 */
	@Autowired
	public AsignaturaService(AsignaturaRepository asignaturaRepository) {
		this.asignaturaRepository = asignaturaRepository;
	}
	
	/**
	 * Metodo para guardar las asignaturas
	 */
	public void saveAsignatura(Asignatura asignatura) {
		asignaturaRepository.save(asignatura);
	}
	
	/**
	 * Metodo para eliminar los registros de la asignatura
	 */
	public void deleteAsignatura(Long id) {
		asignaturaRepository.deleteById(id);
	}
	
	/**
	 * Metodo para consultar todas las asignaturas
	 */
	public List<Asignatura> findAsignaturaAll(){
		List<Asignatura> listAsignaturas = asignaturaRepository.findAll();
		return listAsignaturas;
	}
	
	public Asignatura findAsignaturaById(Long id) {
		Asignatura objAsignatura = null;
		Optional<Asignatura> asignaturaResult = asignaturaRepository.findById(id);
		
		if(asignaturaResult.isPresent()) {
			objAsignatura = asignaturaResult.get();
		}
		return objAsignatura;
	}
}
