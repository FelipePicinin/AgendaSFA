package br.com.AgendaSFA.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.com.AgendaSFA.dao.GenerosDAO;
import br.com.AgendaSFA.dao.SeriesDAO;
import br.com.AgendaSFA.dao.StatusDAO;
import br.com.AgendaSFA.domain.Generos;
import br.com.AgendaSFA.domain.Series;
import br.com.AgendaSFA.domain.Status;
import br.com.AgendaSFA.util.JSFUtil;

@ManagedBean(name = "MBSeries")
@ViewScoped
public class SeriesBean {

	private Series series;
	private List<Series> itens;
	private ArrayList<Series> itensFiltrados;
	private List<Generos> comboGeneros;
	private List<Status> comboStatus;

	
	
	
	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}

	public List<Series> getItens() {
		return itens;
	}

	public void setItens(List<Series> itens) {
		this.itens = itens;
	}

	public ArrayList<Series> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Series> itensFiltrados) {
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
		SeriesDAO dao = new SeriesDAO();
		try {
			itens = dao.listar();
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
		
			}
	
	public void prepararNovo(){
		try{
			series = new Series();
		
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
			SeriesDAO dao = new SeriesDAO();
		dao.salvar(series);
		
		itens = dao.listar();
		
		JSFUtil.adicionarMensagemSucesso("Series Salvo com Sucesso com sucesso");
	}catch(RuntimeException ex){
		ex.printStackTrace();
		JSFUtil.adicionarMensagemErro(ex.getMessage());
	}
}
	
	public void excluir(){
		try{
			SeriesDAO dao = new SeriesDAO();
		
		dao.excluir(series);
		
		itens = dao.listar();
		
		JSFUtil.adicionarMensagemSucesso("Series removidos com sucesso");
	}catch(RuntimeException ex){
		ex.printStackTrace();
		JSFUtil.adicionarMensagemErro(ex.getMessage());
	}
}
	
	public void prepararEditar(){
		try{
			
			series = new Series();
			
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
			SeriesDAO dao = new SeriesDAO();
			dao.editar(series);
			
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Series Editados com sucesso");
		}catch(RuntimeException ex){
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	
}
