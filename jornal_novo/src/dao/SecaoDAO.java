package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import model.Secao;

@Repository
@Transactional
public class SecaoDAO extends GenericDAO<Secao>{

	public List<Secao> listar(){
		String hql = "from Secao s";
		return super.manager.createQuery(hql, Secao.class).getResultList();
		}  
	
}
