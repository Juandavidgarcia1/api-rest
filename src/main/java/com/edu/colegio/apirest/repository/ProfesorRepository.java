/**
 * 
 */
package com.edu.colegio.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.colegio.apirest.model.Profesor;

/**
 * @author JUAN DAVID GARCIA 
 *
 */
@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long>{

}
