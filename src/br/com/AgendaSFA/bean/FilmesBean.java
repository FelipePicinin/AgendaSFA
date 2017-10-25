package br.com.AgendaSFA.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.AgendaSFA.dao.FilmesDAO;
import br.com.AgendaSFA.dao.GenerosDAO;
import br.com.AgendaSFA.domain.Filmes;
import br.com.AgendaSFA.domain.Generos;
import br.com.AgendaSFA.util.JSFUtil;



@ManagedBean(name = "MBFilmes")
@ViewScoped
public class FilmesBean {

	private Filmes filmes;
	private List<Filmes> itens;
	private ArrayList<Filmes> itensFiltrados;
	private List<Generos> comboGeneros;
	public Filmes getFilmes() {
		return filmes;
	}
	public void setFilmes(Filmes filmes) {
		this.filmes = filmes;
	}
	public List<Filmes> getItens() {
		return itens;
	}
	public void setItens(List<Filmes> itens) {
		this.itens = itens;
	}
	public ArrayList<Filmes> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Filmes> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	public List<Generos> getComboGeneros() {
		return comboGeneros;
	}
	public void setComboGeneros(List<Generos> comboGeneros) {
		this.comboGeneros = comboGeneros;
	}
	
	
	public void carregarListagem() {
		FilmesDAO dao = new FilmesDAO();
		try {
			itens = dao.listar();
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
		
			}
	
	public void prepararNovo(){
		try{
			filmes = new Filmes();
		
		GenerosDAO dao = new GenerosDAO();
		
		
		
		comboGeneros = dao.listar();
		
		
		
		}catch(RuntimeException ex){
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
}
	
	public void novo(){
		try{
			FilmesDAO dao = new FilmesDAO();
		dao.salvar(filmes);
		
		itens = dao.listar();
		
		JSFUtil.adicionarMensagemSucesso("Filmes Salvo com Sucesso com sucesso");
	}catch(RuntimeException ex){
		ex.printStackTrace();
		JSFUtil.adicionarMensagemErro(ex.getMessage());
	}
}
	
	public void excluir(){
		try{
			FilmesDAO dao = new FilmesDAO();
		
		dao.excluir(filmes);
		
		itens = dao.listar();
		
		JSFUtil.adicionarMensagemSucesso("Filmes removidos com sucesso");
	}catch(RuntimeException ex){
		ex.printStackTrace();
		JSFUtil.adicionarMensagemErro(ex.getMessage());
	}
}
	
	public void prepararEditar(){
		try{
			
			filmes = new Filmes();
			
			GenerosDAO dao = new GenerosDAO();
			
			
			
			comboGeneros = dao.listar();
			
			
			
			}catch(RuntimeException ex){
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	
	public void editar(){
		try{
			FilmesDAO dao = new FilmesDAO();
			dao.editar(filmes);
			
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Filmes Editados com sucesso");
		}catch(RuntimeException ex){
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	
}
