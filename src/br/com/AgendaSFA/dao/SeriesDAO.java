package br.com.AgendaSFA.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.AgendaSFA.domain.Series;
import br.com.AgendaSFA.util.HibernateUtil;

public class SeriesDAO {

	public void salvar(Series s) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(s);
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
	
	@SuppressWarnings("unchecked")
	public List<Series> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Series> Series = null;

		try {
			Query series = sessao.getNamedQuery("Series.listar");
			Series = series.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return Series;
	}
	
	public void excluir(Series s) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(s);
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
	
	public void editar(Series s) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(s);
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
	
	public Series buscarPorCodigo(Integer id_series) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Series series = null;

		try {
			Query consulta = sessao.getNamedQuery("Series.buscarPorCodigo");
			consulta.setInteger("id_series", id_series);
			series = (Series) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return series;
	}
	
	
	
}
