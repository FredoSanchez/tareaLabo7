package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Estudiante;

@Repository
public class EstudianteDAOImpl implements EstudianteDAO{
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.estudiante");
		Query query = entityManager.createNativeQuery(sb.toString(), Estudiante.class);
		List<Estudiante> resulset = query.getResultList();
		
		return resulset;
	}

	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		Estudiante estudiante = entityManager.find(Estudiante.class, code);
		return estudiante;
	}

	@Override
	@Transactional
	public void save(Estudiante estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			if(estudiante.getCodigoEstudiante()==null) {
				entityManager.persist(estudiante);
			}else {
				entityManager.merge(estudiante);
				entityManager.flush();
			}
		}catch(Throwable e){
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void delete(Integer codigoEstudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		Estudiante estudiante = entityManager.find(Estudiante.class, codigoEstudiante);
		entityManager.remove(estudiante);
	}

}