package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.ModelException;

public class MySQLConnectionFactory {

	// Novo driver JDBC
	// API JDBC >= 3 e Java >= 5
	private static final String JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1/facebook";

	// Credenciais
	static final String USER = "root";
	static final String PASSWORD = "root1234";
	
	public static Connection getConnection() throws ModelException {
		// API JDBC < 3 e Java < 5
		try {
			Class.forName(JDBC_DRIVER_NAME);
			
			// Cria uma conexão com o Banco de Dados
			return DriverManager.getConnection(
					DATABASE_URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			throw new ModelException("Driver não encontrado", e);
		} catch (SQLException e) {
			throw new ModelException("Falha na conexão com o BD", e);
		}
	}
}
