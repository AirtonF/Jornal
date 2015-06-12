package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import model.Secao;

@Repository
public class SecaoDAO extends GenericDAO<Secao>{

	public List<Secao> listar(){
		String hql = "Select t from comentario t";
		return super.manager.createQuery(hql, Secao.class).getResultList();
		}  
}
