package br.com.AgendaSFA.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	private static final String USUARIO = "root";
	private static final String SENHA = "vania10";
	private static final String URL = "jdbc:mysql://localhost:3306/bancosf";

	public static Connection conectar() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}

	public static void main(String[] args) {
		try {
			ConexaoFactory.conectar();
			System.out.println("Conex�o realizada com sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("N�o foi poss�vel realizar a conex�o!");
		}
	}
	
}
