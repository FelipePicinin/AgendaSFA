package br.com.AgendaSFA.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import br.com.AgendaSFA.domain.Anseries;
import br.com.AgendaSFA.util.HibernateUtil;

public class AnseriesDAO {

	public void salvar(Anseries a) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.save(a);
			transacao.commit();
		}catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			// TODO: handle exception
			throw ex;
		}finally {
			sessao.close();
		}
		}
	
	@SuppressWarnings("unchecked")
	public List<Anseries> listar() {
		Session sessao =  HibernateUtil.getSessionFactory().openSession();
		List<Anseries> Anseries = null;
		
		try {
		Query anseries = sessao.getNamedQuery("Anseries.listar");
		Anseries = anseries.list();
		} catch (RuntimeException ex) {
			throw ex;
		}finally {
			sessao.close();
		}
		return Anseries;
	}
	
	
	public void excluir(Anseries a) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(a);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}
	
	public void editar(Anseries a) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(a);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}
	
	public Anseries buscarPorCodigo(Integer id_anseries) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Anseries anseries = null;
		
		try {
			Query consulta = session.getNamedQuery("Anseries.buscarPorCodigo");
		consulta.setInteger("id_anseries", id_anseries);
		anseries = (Anseries) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return anseries;
		
	}
	
	
}
