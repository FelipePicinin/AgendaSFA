package br.com.AgendaSFA.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.com.AgendaSFA.dao.AnseriesDAO;
import br.com.AgendaSFA.dao.SeriesDAO;
import br.com.AgendaSFA.domain.Anseries;
import br.com.AgendaSFA.domain.Series;
import br.com.AgendaSFA.util.JSFUtil;



@ManagedBean(name = "MBAnseries")
@ViewScoped
public class AnseriesBean {

	private Anseries anseries;
	private List<Anseries> itens;
	private ArrayList<Anseries> itensFiltrados;
	private List<Series> comboSeries;
	public Anseries getAnseries() {
		return anseries;
	}
	public void setAnseries(Anseries anseries) {
		this.anseries = anseries;
	}
	public List<Anseries> getItens() {
		return itens;
	}
	public void setItens(List<Anseries> itens) {
		this.itens = itens;
	}
	public ArrayList<Anseries> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Anseries> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	public List<Series> getComboSeries() {
		return comboSeries;
	}
	public void setComboSeries(List<Series> comboSeries) {
		this.comboSeries = comboSeries;
	}
	
	public void carregarListagem() {
		AnseriesDAO dao = new AnseriesDAO();
		try {
			itens = dao.listar();
			
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	public void prepararNovo() {
		try {
			anseries = new Anseries();
			
			SeriesDAO dao = new SeriesDAO();
			
		comboSeries= dao.listar();	
		
		}catch(RuntimeException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
		
	}
	
	public void novo() {
		try {
			AnseriesDAO dao = new AnseriesDAO();
			dao.salvar(anseries);
			
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Series em começo de andamento salvo com sucesso");
				
		}catch(RuntimeException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	public void excluir() {
		try {
			AnseriesDAO dao = new AnseriesDAO();
			dao.excluir(anseries);
			
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Series em andamento removido com sucesso");
				
		}catch(RuntimeException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	public void prepararEditar() {
		try {
			
			anseries = new Anseries();
			
			SeriesDAO dao = new SeriesDAO();
			
			comboSeries = dao.listar();
		}catch(RuntimeException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	public void editar(){
		try{
			AnseriesDAO dao = new AnseriesDAO();
			dao.editar(anseries);
			
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Series em andamento Editados com sucesso");
		}catch(RuntimeException ex){
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
}
