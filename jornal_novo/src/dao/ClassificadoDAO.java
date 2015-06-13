package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import model.Classificado;

@Repository
@Transactional
public class ClassificadoDAO extends GenericDAO<Classificado>{

	public List<Classificado> listar(){
		String hql = "from Classificado c";
		return super.manager.createQuery(hql, Classificado.class).getResultList();
	
		}  
	}
