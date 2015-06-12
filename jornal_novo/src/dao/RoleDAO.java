package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import model.Role;

@Repository
public class RoleDAO extends GenericDAO<Role>{
	
	public List<Role> buscarID(int id){
		String hql = "from Role where id_usuario = '"+ id+"'";
		List<Role> list = super.manager.createQuery(hql, Role.class).getResultList();
		if (list.isEmpty()){
			System.out.println("lista vazia - ROLE" );
		}
		return list;
	}
	
}
