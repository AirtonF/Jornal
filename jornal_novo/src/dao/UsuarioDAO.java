package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import model.Usuario;

@Repository
@Transactional
public class UsuarioDAO extends GenericDAO<Usuario>{

	
	public List<Usuario> listar(){
		String hql = "from Usuario u";
		return super.manager.createQuery(hql, Usuario.class).getResultList();
		}  

	public Usuario buscarUsuario(Usuario u){
		
		String hql = "from Usuario where login = '"+ u.getLogin()+"'";
		List<Usuario> list = super.manager.createQuery(hql, Usuario.class).getResultList();
		if (list.isEmpty())
			return null;
		
		return list.get(0);
		
	}
	

}

