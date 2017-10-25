package br.com.AgendaSFA.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.AgendaSFA.domain.Filmes;
import br.com.AgendaSFA.util.HibernateUtil;

public class FilmesDAO {

	public void salvar(Filmes f) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(f);
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
	public List<Filmes> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Filmes> Filmes = null;

		try {
			Query filmes = sessao.getNamedQuery("Filmes.listar");
			Filmes = filmes.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return Filmes;
	}
	
	public void excluir(Filmes f) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(f);
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
	
	public void editar(Filmes f) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(f);
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
	
	public Filmes buscarPorCodigo(Integer id_filme) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Filmes filmes = null;

		try {
			Query consulta = sessao.getNamedQuery("Filmes.buscarPorCodigo");
			consulta.setInteger("id_filme", id_filme);
			filmes = (Filmes) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return filmes;
	}
	
	
	
}

