package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import model.Classificado;

@Repository
public class ClassificadoDAO extends GenericDAO<Classificado>{

	public List<Classificado> listar(){
		String hql = "Select t from comentario t";
		return super.manager.createQuery(hql, Classificado.class).getResultList();
	
		}  
	}
