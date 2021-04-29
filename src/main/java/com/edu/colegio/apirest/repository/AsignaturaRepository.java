/**
 * 
 */
package com.edu.colegio.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.colegio.apirest.model.Asignatura;

/**
 * @author JUAN DAVID GARCIA
 *
 */
@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long>{

}
