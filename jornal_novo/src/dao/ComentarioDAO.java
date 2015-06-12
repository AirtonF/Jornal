package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import model.Comentario;

@Repository
public class ComentarioDAO extends GenericDAO<Comentario>{

	public List<Comentario> listar(){
		String hql = "Select t from classificado t";
		return super.manager.createQuery(hql, Comentario.class).getResultList();
		}  

}
