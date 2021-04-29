package com.edu.colegio.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.colegio.apirest.model.Colegio;

@Repository
public interface ColegioRepository extends JpaRepository<Colegio, Long>{

}
