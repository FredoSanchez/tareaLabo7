package com.uca.capas.repositories;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.capas.domain.Estudiante;

public interface EstudianteRepo extends JpaRepository<Estudiante, Integer> {
	public List <Estudiante> findBynombre(String cadena) throws DataAccessException;
	
	public List <Estudiante> findByApellidoStartingWith(String cadena) throws DataAccessException;
	
	@Query(nativeQuery=true, value="SELECT * FROM public.estudiante ORDER BY estudiante.id_estudiante ASC")
	public List<Estudiante> mostrarTodos() throws DataAccessException;
}
