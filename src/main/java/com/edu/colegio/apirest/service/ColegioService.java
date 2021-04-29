/**
 * 
 */
package com.edu.colegio.apirest.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.colegio.apirest.model.Colegio;
import com.edu.colegio.apirest.repository.ColegioRepository;

/**
 * @author JEISSON
 *
 */
@Service
@Transactional
public class ColegioService {
	
	private final ColegioRepository colegioRepository;

	/**
	 * @param colegioRepository
	 */
	@Autowired
	public ColegioService(ColegioRepository colegioRepository) {
		this.colegioRepository = colegioRepository;
	}
	
	/**
	 * Metodo para guardar el registro del colegio
	 */
	public void saveColegio(Colegio colegio) {
		colegioRepository.save(colegio);
	}
	
	/**
	 * Metodo para eliminar el colegio por el id
	 */
	public void deleteColegio(Long id) {
		colegioRepository.deleteById(id);
	}
	
	/**
	 * Metodo para consultar todos los registros de la asignatura
	 */
	public List<Colegio> findColegioAll(){
		List<Colegio> colegioList = colegioRepository.findAll();
		return colegioList;
	}
	
	/**
	 * Metodo para colsultar el registro del colegio, por el id
	 */
	public Colegio findColegioById(Long id) {
		Colegio objColegio = null;
		Optional<Colegio> colegioResult = colegioRepository.findById(id);
		
		if(colegioResult.isPresent()) {
			objColegio = colegioResult.get();
		}
		return objColegio;
	}
}
