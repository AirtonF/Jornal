package model;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Noticia")
public class Noticia {
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional= false)
	@JoinColumn(name = "id_secao", referencedColumnName = "secao_id")
	private Secao secao;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "noticia_id")
	private int id;
	
	@Column(nullable = false , length = 50)
	private String titulo;
	
	@Column(nullable = false , length = 150)
	private String subtitulo;
	
	@Column(nullable = false , length = 500)
	private String texto;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional= false)
	@JoinColumn(name = "autor", referencedColumnName = "usuario_id")
	private Usuario autor;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_noticia")
	private Date dataNoticia;
	
	
	public Noticia() {
		super();
	}

	public Noticia(Secao secao, int id, String titulo, String subtitulo,
			String texto, Usuario autor, Date dataNoticia) {
		super();
		this.secao = secao;
		this.id = id;
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.texto = texto;
		this.autor = autor;
		this.dataNoticia = dataNoticia;
	}

	@Override
	public String toString() {
		return "noticia [secao=" + secao + ", id=" + id + ", titulo=" + titulo
				+ ", subtitulo=" + subtitulo + ", texto=" + texto + ", autor="
				+ autor + ", dataNoticia=" + dataNoticia + "]";
	}

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Date getDataNoticia() {
		return dataNoticia;
	}

	public void setDataNoticia(Date dataNoticia) {
		this.dataNoticia = dataNoticia;
	}

		
	
}
