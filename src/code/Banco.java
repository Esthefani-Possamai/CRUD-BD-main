package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {
	String host = "localhost";
	String database = "student_management";
	String user = "root";
	String pass = "";
	String url = "jdbc:mysql://" + host + "/" + database;
	
	Connection conexao;
	
	public Connection getConexao () {
		try {
			conexao = DriverManager.getConnection(url, user,pass);
			System.out.println("Banco de dados conectado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return conexao;
	}
	
	public void fechaConexao() {
		if (conexao != null) {
			try {
				conexao.close();
				System.out.println("Conexão fechada");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}
}
