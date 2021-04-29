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
@Table(name="curso")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "grado")
	private Integer grado;

	@Column(name = "idcolegio")
	private Long idColegio;	
	
	@Column(name = "salon")
	private String salon;

	/**
	 * @param grado
	 * @param salon
	 * @param idColegio
	 * @param idAsignatura
	 */
	public Curso(Integer grado, String salon, Long idColegio) {
		this.grado = grado;
		this.salon = salon;
		this.idColegio = idColegio;
	}

	/**
	 * 
	 */
	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}	

	/**
	 * @return the idColegio
	 */
	public Long getIdColegio() {
		return idColegio;
	}

	/**
	 * @param idColegio the idColegio to set
	 */
	public void setIdColegio(Long idColegio) {
		this.idColegio = idColegio;
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
	 * @return the grado
	 */
	public Integer getGrado() {
		return grado;
	}

	/**
	 * @param grado the grado to set
	 */
	public void setGrado(Integer grado) {
		this.grado = grado;
	}

	/**
	 * @return the salon
	 */
	public String getSalon() {
		return salon;
	}

	/**
	 * @param salon the salon to set
	 */
	public void setSalon(String salon) {
		this.salon = salon;
	}	
}
