package metas.crud;

import java.sql.*;

public class Conexao {
	
	private Connection conexao;
	private final String URL = "jdbc:mysql://localhost:3306/db_app_metas";
	private final String USUARIO =  "root";
	private final String SENHA = "1234";
	
	public void conectar() throws SQLException {
		conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
	}
	
	public void fecharConexao() throws SQLException {
		conexao.close();
	}

	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
	
}
