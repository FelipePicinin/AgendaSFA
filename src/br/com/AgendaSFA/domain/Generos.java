package br.com.AgendaSFA.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "generos")
@NamedQueries({
	@NamedQuery(name = "Generos.listar", query = "SELECT generos FROM Generos generos"),
	@NamedQuery(name = "Generos.buscarPorCodigo", query = "SELECT generos FROM Generos generos WHERE id_genero = :id_genero")
})
public class Generos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_genero")
	private int id_genero;
	@Column(name = "descricao", length = 20, nullable = false )
	private String descricao;
	
	
	public int getId_genero() {
		return id_genero;
	}
	public void setId_genero(int id_genero) {
		this.id_genero = id_genero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	

}
