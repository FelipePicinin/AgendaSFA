package br.com.AgendaSFA.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "series")
@NamedQueries({
	@NamedQuery(name = "Series.listar", query = "SELECT series FROM Series series"),
	@NamedQuery(name = "Series.buscarPorCodigo", query = "SELECT series FROM Series series WHERE id_series = :id_series ")
})
public class Series {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_series")
	private int id_series;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "generos", referencedColumnName = "id_genero", nullable = false)
	private Generos generos = new Generos();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "status", referencedColumnName = "id_status", nullable = false)
	private Status status = new Status();
	
	@Column(name = "nome", length = 30, nullable = false)
	private String nome;
	
	@Column(name = "temporada", length = 15, nullable = false)
	private String temporada;
	
	@Column(name = "episodio")
	private int episodio;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "ano_lan", nullable = false)
	private Date ano_lan;

	public int getId_series() {
		return id_series;
	}

	public void setId_series(int id_series) {
		this.id_series = id_series;
	}

	public Generos getGeneros() {
		return generos;
	}

	public void setGeneros(Generos generos) {
		this.generos = generos;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public int getEpisodio() {
		return episodio;
	}

	public void setEpisodio(int episodio) {
		this.episodio = episodio;
	}

	public Date getAno_lan() {
		return ano_lan;
	}

	public void setAno_lan(Date ano_lan) {
		this.ano_lan = ano_lan;
	}
	
	
	
}
