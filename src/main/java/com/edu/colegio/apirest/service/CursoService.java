/**
 * 
 */
package com.edu.colegio.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.colegio.apirest.model.Curso;
import com.edu.colegio.apirest.repository.CursoRepository;

/**
 * @author JEISSON
 *
 */
@Service
public class CursoService {
	
	private final CursoRepository cursoRepository;

	/**
	 * @param cursoRepository
	 */
	@Autowired
	public CursoService(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}
	
	//Metodo pàra guardar el registro del curso
	public void saveCurso(Curso curso) {
		cursoRepository.save(curso);
	}
	
	//Metodo pàra eliminar el registro del curso
	public void deleteCurso(Long id) {
		cursoRepository.deleteById(id);
	}
	
	//Metodo para buscar todos los registros del curso
	public List<Curso> findCursoAll(){
		List<Curso> cursoList = cursoRepository.findAll();
		return cursoList;
	}
	
	//Metodo para buscar todos los registros del curso por el id
	public Curso findCursoById(Long id){
		Curso objCurso= null;
		Optional<Curso> cursoList = cursoRepository.findById(id);
		
		if(cursoList.isPresent()) {
			objCurso = cursoList.get();
		}
		return objCurso;
	}
}
