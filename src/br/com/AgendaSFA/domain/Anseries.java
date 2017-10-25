package br.com.AgendaSFA.domain;

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

@Entity
@Table(name = "anseries")
@NamedQueries({
	@NamedQuery(name = "Anseries.listar", query = "SELECT anseries FROM Anseries anseries" ),
	@NamedQuery(name = "Anseries.buscarPorCodigo", query = "SELECT anseries FROM Anseries anseries WHERE id_anseries = :id_anseries")
})
public class Anseries {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_anseries")
	private int id_anseries;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "series", referencedColumnName = "id_series", nullable = false )
	private Series series = new Series();

	@Column(name = "episodio")
	private int episodio;

	@Column(name = "temporada", length = 15, nullable = false)
	private String temporada;

	public int getId_anseries() {
		return id_anseries;
	}

	public void setId_anseries(int id_anseries) {
		this.id_anseries = id_anseries;
	}

	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}

	public int getEpisodio() {
		return episodio;
	}

	public void setEpisodio(int episodio) {
		this.episodio = episodio;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	
	
}
