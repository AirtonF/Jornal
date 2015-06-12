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



@Entity
@Table(name="Classificado")
public class Classificado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "classificado_id")
	private int id;
	
	@Column(nullable = false , length = 50)
	private String titulo;
	
	@Column(nullable = false , length = 250)
	private String texto;
	
	@Column(nullable = false , precision = 2)
	private float preço;
	
	@Column(nullable = false , length = 20)
	private String telefone;
	
	@Column(name="melhor_oferta")
	private float melhorOferta;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional= false)
	@JoinColumn(name = "autor_oferta", referencedColumnName = "login")
	private Usuario autor;
	
	@Column(name="data_oferta")
	private Date dataOferta;
	
	public Classificado() {
		super();
	}

	public Classificado(int id, String titulo , String texto, float preço, String telefone,
			float melhorOferta, Usuario autor, Date dataOferta) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.preço = preço;
		this.telefone = telefone;
		this.melhorOferta = melhorOferta;
		this.autor = autor;
		this.dataOferta = dataOferta;
	}

	@Override
	public String toString() {
		return "Classificado [id=" + id + ", titulo=" + titulo + ", preço="
				+ preço + ", telefone=" + telefone + ", melhorOferta="
				+ melhorOferta + ", autor=" + autor + ", dataOferta="
				+ dataOferta + "]";
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
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public float getPreço() {
		return preço;
	}

	public void setPreço(float preço) {
		this.preço = preço;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public float getMelhorOferta() {
		return melhorOferta;
	}

	public void setMelhorOferta(float melhorOferta) {
		this.melhorOferta = melhorOferta;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Date getDataOferta() {
		return dataOferta;
	}

	public void setDataOferta(Date dataOferta) {
		this.dataOferta = dataOferta;
	}
	
	
}
