package br.com.AgendaSFA.main;

import br.com.AgendaSFA.util.HibernateUtil;

public class GeraTabela {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();

	}
	

}
