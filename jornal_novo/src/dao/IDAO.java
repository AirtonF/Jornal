package dao;

import java.util.List;

public interface IDAO<T> {
	public void adicinar(T t);
	public void remover(T t);
	public void alterar(T t);
	public List<T> listarGenerico(String tabela);
	public String getNome();
	
}
