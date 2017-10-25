package br.com.AgendaSFA.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.AgendaSFA.domain.Ananimes;
import br.com.AgendaSFA.util.HibernateUtil;

public class AnanimesDAO {

	public void salvar(Ananimes a) {
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
	public List<Ananimes> listar() {
		Session sessao =  HibernateUtil.getSessionFactory().openSession();
		List<Ananimes> Ananimes = null;
		
		try {
		Query ananimes = sessao.getNamedQuery("Ananimes.listar");
		Ananimes = ananimes.list();
		} catch (RuntimeException ex) {
			throw ex;
		}finally {
			sessao.close();
		}
		return Ananimes;
	}
	
	public void excluir(Ananimes a) {
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
	
	
	public void editar(Ananimes a) {
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
	
	public Ananimes buscarPorCodigo(Integer id_ananimes) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Ananimes ananimes = null;
		
		try {
			Query consulta = session.getNamedQuery("Ananimes.buscarPorCodigo");
		consulta.setInteger("id_ananimes", id_ananimes);
		ananimes = (Ananimes) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return ananimes;
		
	}
	
	
}
