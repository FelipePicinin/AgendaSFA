package br.com.AgendaSFA.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.AgendaSFA.domain.Animes;
import br.com.AgendaSFA.util.HibernateUtil;


public class AnimesDAO {

	public void salvar(Animes an) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(an);
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
	public List<Animes> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Animes> Animes = null;

		try {
			Query animes = sessao.getNamedQuery("Animes.listar");
			Animes = animes.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return Animes;
	}
	
	public void excluir(Animes an) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(an);
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
	
	public void editar(Animes an) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(an);
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
	
	public Animes buscarPorCodigo(Integer id_anime) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Animes animes = null;

		try {
			Query consulta = sessao.getNamedQuery("Animes.buscarPorCodigo");
			consulta.setInteger("id_anime", id_anime);
			animes = (Animes) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return animes;
	}
	
	
	
}
