package model;

import java.nio.MappedByteBuffer;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dao.RoleDAO;

@Entity
@Table(name="Role")
public class Role {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "role_id")
	private long role_id = 1;
	
	public long getRole_id() {
		return role_id;
	}


	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}


	@ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
	private Set<Usuario> id_usuario;
	
	@Column(nullable = false , length = 20)
	private String role;
	
	
	public Role() {
		super();
	}


	public Role(Set<Usuario> id_usuario, String role) {
		super();
		this.id_usuario = id_usuario;
		this.role = role;
	}


	@Override
	public String toString() {
		return "Role [id_usuario=" + id_usuario + ", role=" + role + "]";
	}


	public Set<Usuario> getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(Set<Usuario> id_usuario) {
		this.id_usuario = id_usuario;
	}


	public String getRole() {
		return role;
	}


}
