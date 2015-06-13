package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import model.Noticia;

@Repository
public class NoticiaDAO extends GenericDAO<Noticia>{

	public List<Noticia> listar(){
		String hql = "from Noticia n";
		return super.manager.createQuery(hql, Noticia.class).getResultList();
		}  
	
}
