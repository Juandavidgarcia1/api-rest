/**
 * 
 */
package com.edu.colegio.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.colegio.apirest.model.Profesor;
import com.edu.colegio.apirest.repository.ProfesorRepository;

/**
 * @author JEISSON
 *
 */
@Service
public class ProfesorService {
	
	private final ProfesorRepository profesorRepository;

	/**
	 * @param profesorRepository
	 */
	@Autowired
	public ProfesorService(ProfesorRepository profesorRepository) {
		this.profesorRepository = profesorRepository;
	}
	
	//Metodo para crear el registro del profesor
	public void saveProfesor(Profesor profesor) {
		profesorRepository.save(profesor);
	}
	
	//Metodo para eliminar al profesor
	public void deleteProfesor(Long id) {
		profesorRepository.deleteById(id);
	}
	
	//Metodo para consultar todos los registros del profesor
	public List<Profesor> findProfesorAll(){
		List<Profesor> profesorList = profesorRepository.findAll();
		return profesorList;
	}
	
	//Metodo para consultar todos los registros del profesor por el id
	public Profesor findProfesorById(Long id){
		Profesor objProfesor = null;
		Optional<Profesor> profesorList = profesorRepository.findById(id);
		
		if(profesorList.isPresent()) {
			objProfesor = profesorList.get();
		}
		return objProfesor;
	}
}
