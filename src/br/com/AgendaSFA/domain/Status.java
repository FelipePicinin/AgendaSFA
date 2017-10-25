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
@Table(name = "status")
@NamedQueries({
	@NamedQuery(name = "Status.listar", query = "SELECT status FROM Status status"),
	@NamedQuery(name = "Status.buscarPorCodigo", query = "SELECT status FROM Status status WHERE id_status = :id_status")
})
public class Status {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_status")
	private int id_status;
	@Column(name = "descricao", length = 15, nullable = false )
	private String descricao;
	
	public int getId_status() {
		return id_status;
	}
	public void setId_status(int id_status) {
		this.id_status = id_status;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
