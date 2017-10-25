package br.com.AgendaSFA.bean;


import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.AgendaSFA.dao.StatusDAO;
import br.com.AgendaSFA.domain.Status;
import br.com.AgendaSFA.util.JSFUtil;

@ManagedBean(name = "MBStatus")
@ViewScoped
public class StatusBean {

	private Status status;
	private ArrayList<Status> itens;
	private ArrayList<Status> itensFiltrados;
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public ArrayList<Status> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Status> itens) {
		this.itens = itens;
	}
	public ArrayList<Status> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Status> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			StatusDAO dao = new StatusDAO();
			itens = (ArrayList<Status>) dao.listar();
			
			
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	public void prepararNovo(){
		status = new Status();
	}

	public void novo() {
				try {
					StatusDAO dao = new StatusDAO();
			dao.salvar(status);
			
			itens = (ArrayList<Status>) dao.listar();
			
			
			JSFUtil.adicionarMensagemSucesso("Status salvo com sucessos!");
				} catch (RuntimeException ex) {
					ex.printStackTrace();
					JSFUtil.adicionarMensagemErro(ex.getMessage());
				}
	}
	
	
	
	public void excluir(){
		try {
			StatusDAO dao = new StatusDAO();
		dao.excluir(status);
			
		itens = (ArrayList<Status>) dao.listar();
			
			
			JSFUtil.adicionarMensagemSucesso("Status removidos com sucesso");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	
		
	public void editar(){
		try {
			StatusDAO dao = new StatusDAO();
			dao.editar(status);
				
			itens = (ArrayList<Status>) dao.listar();
				
				
				JSFUtil.adicionarMensagemSucesso("Status editados com sucesso");
			} catch (RuntimeException ex) {
				ex.printStackTrace();
				JSFUtil.adicionarMensagemErro(ex.getMessage());
			}
	}
	
}
