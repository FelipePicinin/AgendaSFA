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
@Table(name = "filmes")
@NamedQueries({
	@NamedQuery(name = "Filmes.listar", query = "SELECT filmes FROM Filmes filmes"),
	@NamedQuery(name = "Filmes.buscarPorCodigo", query = "SELECT filmes FROM Filmes filmes WHERE id_filme = :id_filme ")
})
public class Filmes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_filme")
	private int id_filme;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "generos", referencedColumnName = "id_genero", nullable = false)
	private Generos generos = new Generos();
	
	@Column(name = "nome", length = 30, nullable = false)
	private String nome;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "ano_lan", nullable = false)
	private Date ano_lan;

	public int getId_filme() {
		return id_filme;
	}

	public void setId_filme(int id_filme) {
		this.id_filme = id_filme;
	}

	public Generos getGeneros() {
		return generos;
	}

	public void setGeneros(Generos generos) {
		this.generos = generos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getAno_lan() {
		return ano_lan;
	}

	public void setAno_lan(Date ano_lan) {
		this.ano_lan = ano_lan;
	}
	
	

	
}
