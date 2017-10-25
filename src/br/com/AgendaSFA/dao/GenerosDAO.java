package br.com.AgendaSFA.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.AgendaSFA.domain.Generos;
import br.com.AgendaSFA.util.HibernateUtil;

public class GenerosDAO {
	
	
	public void salvar(Generos  g) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(g);
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
	public List<Generos> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Generos> generos = null;

		try {
			Query consulta = sessao.getNamedQuery("Generos.listar");
			generos = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return generos;
	}
	
	public void excluir(Generos g) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(g);
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
	
	public void editar(Generos g) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(g);
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
	
	public Generos buscarPorCodigo(Integer id_genero) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Generos generos = null;

		try {
			Query consulta = sessao.getNamedQuery("Generos.buscarPorCodigo");
			consulta.setInteger("id_genero", id_genero);
			generos = (Generos) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return generos;
	}

}
