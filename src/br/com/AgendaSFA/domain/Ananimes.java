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
@Table(name = "ananimes")
@NamedQueries({
	@NamedQuery(name = "Ananimes.listar", query = "SELECT ananimes FROM Ananimes ananimes" ),
	@NamedQuery(name = "Ananimes.buscarPorCodigo", query = "SELECT ananimes FROM Ananimes ananimes WHERE id_ananimes = :id_ananimes")
})
public class Ananimes {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id_ananimes")
private int id_ananimes;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "animes", referencedColumnName = "id_anime", nullable = false )
private Animes animes = new Animes();

@Column(name = "episodio")
private int episodio;

@Column(name = "temporada", length = 15, nullable = false)
private String temporada;

public int getId_an() {
	return id_ananimes;
}

public void setId_an(int id_ananimes) {
	this.id_ananimes = id_ananimes;
}

public Animes getAnimes() {
	return animes;
}

public void setAnimes(Animes animes) {
	this.animes = animes;
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
