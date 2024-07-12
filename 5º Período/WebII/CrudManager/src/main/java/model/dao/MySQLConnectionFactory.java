package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.ModelException;

public class MySQLConnectionFactory {

	// Nome do Driver (classe) e URL do banco
	private static final String JDBC_DRIVER_NAME = 
			"com.mysql.jdbc.Driver";
	
//	private static final String DATABASE_URL = 
//			"jdbc:mysql://127.0.0.1/facebook";
	private static final String DATABASE_URL = 
			"jdbc:mysql://localhost:3306/crud_manager";

	// Credenciais
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
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