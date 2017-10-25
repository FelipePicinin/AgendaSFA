package br.com.AgendaSFA.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.AgendaSFA.domain.Status;
import br.com.AgendaSFA.util.HibernateUtil;

public class StatusDAO {

	public void salvar(Status s) {
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
	public List<Status> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Status> status = null;

		try {
			Query consulta = sessao.getNamedQuery("Status.listar");
			status = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return status;
	}
	
	public void excluir(Status s) {
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
	
	public void editar(Status s) {
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
	
	public Status buscarPorCodigo(Integer id_status) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Status status = null;

		try {
			Query consulta = sessao.getNamedQuery("Status.buscarPorCodigo");
			consulta.setInteger("id_status", id_status);
			status = (Status) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return status;
	}

	
}
