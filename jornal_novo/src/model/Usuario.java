package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;




@Entity
@Table(name="Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "usuario_id")
	private int id;
	
	@Column(name = "login",nullable = false , length = 20, unique = true)
	private String login;
	
	@Column(nullable = false , length = 20)
	private String senha;
	
	@Column(nullable = false , length = 50)
	private String nome;
	
	@Column(nullable = false , length = 50)
	private String email;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ROLE_USUARIO", 
			joinColumns = {@JoinColumn(name = "usuario_id")},  
			inverseJoinColumns= {@JoinColumn(name = "role_id")})
	private Set<Role> roles =  new HashSet<Role>();
	
	
	public Usuario() {
		super();
	}


public Usuario(int id, String login, String senha, String nome,
			String email, Set<Role> roles) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.roles = roles;
	}






	@Override
	public String toString() {
		return "usuario [login=" + login + ", senha=" + senha + ", nome="
				+ nome + ", email=" + email + "]";
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}




	
	
	
	
	
	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public void addRole(Role a){
		this.roles.add(a);
	}
	
	public void RomoverRole(int id){
		this.roles.remove(id);
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
