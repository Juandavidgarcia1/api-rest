/**
 * 
 */
package com.edu.colegio.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.colegio.apirest.model.Estudiante;
import com.edu.colegio.apirest.repository.EstudianteRepository;

/**
 * @author JEISSON
 *
 */
@Service
public class EstudianteService {
	
	private final EstudianteRepository estudianteRepository;

	/**
	 * @param estudianteRepository
	 */
	@Autowired
	public EstudianteService(EstudianteRepository estudianteRepository) {
		this.estudianteRepository = estudianteRepository;
	}
	
	//Metodo para crear el registro del estudiante
	public void saveEstudiante(Estudiante estudiante) {
		estudianteRepository.save(estudiante);
	}	
	
	//Metodo para eliminar el registro del estudiante
	public void deleteEstudiante(Long id) {
		estudianteRepository.deleteById(id);
	}
	
	//Metodo para consultar todos los registros del estudiante
	public List<Estudiante> findEstudianteAll(){
		List<Estudiante> estudianteList = estudianteRepository.findAll();
		return estudianteList;
	}
	
	//Metodo para buscar los registros del estudiante por el id
	public Estudiante findEstudianteById(Long id){
		Estudiante objEstudiante = null;
		Optional<Estudiante> estudianteList = estudianteRepository.findById(id);
		
		if(estudianteList.isPresent()) {
			objEstudiante = estudianteList.get();
		}
		return objEstudiante;
	}
}
