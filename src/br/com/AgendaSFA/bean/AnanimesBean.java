package br.com.AgendaSFA.bean;


import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.AgendaSFA.dao.AnanimesDAO;
import br.com.AgendaSFA.dao.AnimesDAO;
import br.com.AgendaSFA.domain.Ananimes;
import br.com.AgendaSFA.domain.Animes;
import br.com.AgendaSFA.util.JSFUtil;

@ManagedBean(name = "MBAnanimes")
@ViewScoped
public class AnanimesBean {

	private Ananimes ananimes;
	private List<Ananimes> itens;
	private ArrayList<Ananimes> itensFiltrados;
	private List<Animes> comboAnimes;
	public Ananimes getAnanimes() {
		return ananimes;
	}
	public void setAnanimes(Ananimes ananimes) {
		this.ananimes = ananimes;
	}
	public List<Ananimes> getItens() {
		return itens;
	}
	public void setItens(List<Ananimes> itens) {
		this.itens = itens;
	}
	public ArrayList<Ananimes> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Ananimes> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	public List<Animes> getComboAnimes() {
		return comboAnimes;
	}
	public void setComboAnimes(List<Animes> comboAnimes) {
		this.comboAnimes = comboAnimes;
	}
	
	
	public void carregarListagem() {
		AnanimesDAO dao = new AnanimesDAO();
		try {
			itens = dao.listar();
			
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	public void prepararNovo() {
		try {
			ananimes = new Ananimes();
			
			AnimesDAO dao = new AnimesDAO();
			
		comboAnimes = dao.listar();	
		
		}catch(RuntimeException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
		
	}
	
	public void novo() {
		try {
			AnanimesDAO dao = new AnanimesDAO();
			dao.salvar(ananimes);
			
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Animes em começo de andamento salvo com sucesso");
				
		}catch(RuntimeException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	public void excluir() {
		try {
			AnanimesDAO dao = new AnanimesDAO();
			dao.excluir(ananimes);
			
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Animes em andamento removido com sucesso");
				
		}catch(RuntimeException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	public void prepararEditar() {
		try {
			
			ananimes = new Ananimes();
			
			AnimesDAO dao = new AnimesDAO();
			
			comboAnimes = dao.listar();
		}catch(RuntimeException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	public void editar(){
		try{
			AnanimesDAO dao = new AnanimesDAO();
			dao.editar(ananimes);
			
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Animes em andamento Editados com sucesso");
		}catch(RuntimeException ex){
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
}
