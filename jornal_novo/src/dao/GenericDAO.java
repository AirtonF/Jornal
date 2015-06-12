package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import model.Classificado;
import model.Comentario;
import model.Noticia;
import model.Secao;
import model.Usuario;


@Repository
public class GenericDAO<T> implements IDAO<T> {

	@PersistenceContext
	protected EntityManager manager;
	
	@Override
	public void adicinar(T t) {
		this.manager.persist(t);
	}

	@Override
	public void remover(T t) {
		manager.remove(t);
	}

	@Override
	public void alterar(T t) {
		this.manager.merge(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listarGenerico(String tabela) {
		String hql = "Select t from "+tabela+" t";
		return (List<T>) this.manager.createQuery(hql, getClass()).getResultList();}

	@Override
	public String getNome() {
		
		Object obj = new GenericDAO<Classificado>();
		if (this.getClass() == obj.getClass())
				return "Classificado";
		
		obj = new GenericDAO<Comentario>();
		if (this.getClass() == obj.getClass())
				return "Comentario";

		obj = new GenericDAO<Noticia>();
		if (this.getClass() == obj.getClass())
				return "Noticia";

		obj = new GenericDAO<Secao>();
		if (this.getClass() == obj.getClass())
				return "Secao";


		obj = new GenericDAO<Usuario>();
		if (this.getClass() == obj.getClass())
				return "Usuario";

		
		return null;
	}
}
