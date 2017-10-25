package br.com.AgendaSFA.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.AgendaSFA.dao.AnimesDAO;
import br.com.AgendaSFA.dao.GenerosDAO;
import br.com.AgendaSFA.dao.StatusDAO;
import br.com.AgendaSFA.domain.Animes;
import br.com.AgendaSFA.domain.Generos;
import br.com.AgendaSFA.domain.Status;
import br.com.AgendaSFA.util.JSFUtil;

@ManagedBean(name = "MBAnimes")
@ViewScoped
public class AnimesBean {

	private Animes animes;
	private List<Animes> itens;
	private ArrayList<Animes> itensFiltrados;
	private List<Generos> comboGeneros;
	private List<Status> comboStatus;
	public Animes getAnimes() {
		return animes;
	}
	public void setAnimes(Animes animes) {
		this.animes = animes;
	}
	public List<Animes> getItens() {
		return itens;
	}
	public void setItens(List<Animes> itens) {
		this.itens = itens;
	}
	public ArrayList<Animes> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Animes> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	public List<Generos> getComboGeneros() {
		return comboGeneros;
	}
	public void setComboGeneros(List<Generos> comboGeneros) {
		this.comboGeneros = comboGeneros;
	}
	public List<Status> getComboStatus() {
		return comboStatus;
	}
	public void setComboStatus(List<Status> comboStatus) {
		this.comboStatus = comboStatus;
	}
	
	
	public void carregarListagem() {
		AnimesDAO dao = new AnimesDAO();
		try {
			itens = dao.listar();
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
		
			}
	
	public void prepararNovo(){
		try{
			animes = new Animes();
		
		GenerosDAO dao = new GenerosDAO();
		StatusDAO daoq = new StatusDAO();
		
		
		comboGeneros = dao.listar();
		comboStatus = daoq.listar();
		
		
		}catch(RuntimeException ex){
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
}
	
	public void novo(){
		try{
			AnimesDAO dao = new AnimesDAO();
		dao.salvar(animes);
		
		itens = dao.listar();
		
		JSFUtil.adicionarMensagemSucesso("Animes Salvo com Sucesso com sucesso");
	}catch(RuntimeException ex){
		ex.printStackTrace();
		JSFUtil.adicionarMensagemErro(ex.getMessage());
	}
}
	
	public void excluir(){
		try{
			AnimesDAO dao = new AnimesDAO();
		
		dao.excluir(animes);
		
		itens = dao.listar();
		
		JSFUtil.adicionarMensagemSucesso("Animes removidos com sucesso");
	}catch(RuntimeException ex){
		ex.printStackTrace();
		JSFUtil.adicionarMensagemErro(ex.getMessage());
	}
}
	
	public void prepararEditar(){
		try{
			
			animes = new Animes();
			
			GenerosDAO dao = new GenerosDAO();
			StatusDAO daoq = new StatusDAO();
			
			
			comboGeneros = dao.listar();
			comboStatus = daoq.listar();
			
			
			}catch(RuntimeException ex){
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	
	public void editar(){
		try{
			AnimesDAO dao = new AnimesDAO();
			dao.editar(animes);
			
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Animes Editados com sucesso");
		}catch(RuntimeException ex){
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
}
