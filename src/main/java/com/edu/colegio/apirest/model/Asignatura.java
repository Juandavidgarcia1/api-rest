/**
 * 
 */
package com.edu.colegio.apirest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author JUAN DAVID GARCIA
 *
 */
@Entity
@Table(name="asignatura")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Asignatura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;
		
	@Column(name = "idprofesor")
	private Long idprofesor;
		
	@Column(name = "idcurso")
	private Long idcurso;

	/**
	 * 
	 */
	public Asignatura() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nombre
	 * @param idProfesor
	 * @param idCurso
	 */
	public Asignatura(String nombre, Long idProfesor, Long idCurso) {
		this.nombre = nombre;
		this.idprofesor = idProfesor;
		this.idcurso = idCurso;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the idProfesor
	 */
	public Long getIdProfesor() {
		return idprofesor;
	}

	/**
	 * @param idProfesor the idProfesor to set
	 */
	public void setIdProfesor(Long idProfesor) {
		this.idprofesor = idProfesor;
	}

	/**
	 * @return the idCurso
	 */
	public Long getIdCurso() {
		return idcurso;
	}

	/**
	 * @param idCurso the idCurso to set
	 */
	public void setIdCurso(Long idCurso) {
		this.idcurso = idCurso;
	}		
}
