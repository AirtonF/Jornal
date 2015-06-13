package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Comentario")
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="comentario_id")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, optional= false)
	@JoinColumn(name = "autor", referencedColumnName = "usuario_id")
	private Usuario autor;
	
	@ManyToOne(fetch = FetchType.EAGER, optional= false)
	@JoinColumn(name = "id_noticia", referencedColumnName = "noticia_id")
	private Noticia noticia;
	
	@Column(nullable = false , length = 100)
	private String texto;


public Comentario() {
	super();
}


public Comentario(int idComentario, Usuario idAutor, Noticia idNoticia, String texto) {
	super();
	this.id = idComentario;
	this.autor = idAutor;
	this.noticia = idNoticia;
	this.texto = texto;
}


@Override
public String toString() {
	return "comentario [idComentario=" + id + ", idAutor=" + autor
			+ ", idNoticia=" + noticia + ", texto=" + texto + "]";
}


public int getIdComentario() {
	return id;
}


public void setIdComentario(int idComentario) {
	this.id = idComentario;
}


public Usuario getIdAutor() {
	return autor;
}


public void setIdAutor(Usuario idAutor) {
	this.autor = idAutor;
}


public Noticia getIdNoticia() {
	return noticia;
}


public void setIdNoticia(Noticia idNoticia) {
	this.noticia = idNoticia;
}


public String getTexto() {
	return texto;
}


public void setTexto(String texto) {
	this.texto = texto;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public Usuario getAutor() {
	return autor;
}


public void setAutor(Usuario autor) {
	this.autor = autor;
}


public Noticia getNoticia() {
	return noticia;
}


public void setNoticia(Noticia noticia) {
	this.noticia = noticia;
}



}
