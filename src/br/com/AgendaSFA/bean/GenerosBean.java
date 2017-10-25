package br.com.AgendaSFA.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.AgendaSFA.dao.GenerosDAO;
import br.com.AgendaSFA.domain.Generos;
import br.com.AgendaSFA.util.JSFUtil;

@ManagedBean(name = "MBGeneros")
@ViewScoped
public class GenerosBean {
	
	private Generos generos;
	private ArrayList<Generos> itens;
	private ArrayList<Generos> itensFiltrados;
	
	public Generos getGeneros() {
		return generos;
	}

	public void setGeneros(Generos generos) {
		this.generos = generos;
	}

	public ArrayList<Generos> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Generos> itens) {
		this.itens = itens;
	}

	public ArrayList<Generos> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Generos> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			GenerosDAO dao = new GenerosDAO();
			itens = (ArrayList<Generos>) dao.listar();
			
			
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	public void prepararNovo(){
		generos = new Generos();
	}

	public void novo() {
				try {
					GenerosDAO dao = new GenerosDAO();
			dao.salvar(generos);
			
			itens = (ArrayList<Generos>) dao.listar();
			
			
			JSFUtil.adicionarMensagemSucesso("Generos salvos com sucessos!");
				} catch (RuntimeException ex) {
					ex.printStackTrace();
					JSFUtil.adicionarMensagemErro(ex.getMessage());
				}
	}
	
	
	
	public void excluir(){
		try {
			GenerosDAO dao = new GenerosDAO();
		dao.excluir(generos);
			
		itens = (ArrayList<Generos>) dao.listar();
			
			
			JSFUtil.adicionarMensagemSucesso("Generos removidos com sucesso");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	
		
	public void editar(){
		try {
			GenerosDAO dao = new GenerosDAO();
			dao.editar(generos);
				
			itens = (ArrayList<Generos>) dao.listar();
				
				
				JSFUtil.adicionarMensagemSucesso("Generos editados com sucesso");
			} catch (RuntimeException ex) {
				ex.printStackTrace();
				JSFUtil.adicionarMensagemErro(ex.getMessage());
			}
	}
}
