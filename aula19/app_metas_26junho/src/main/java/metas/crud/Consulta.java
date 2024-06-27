package metas.crud;

import java.sql.*;

public class Consulta extends Conexao {
	
	private PreparedStatement declaracao;
	private ResultSet resultado;
	
	public void consultarTodos () throws SQLException {
		conectar();
		declaracao = getConexao().prepareStatement("SELECT * FROM tb_usuario");
		resultado = declaracao.executeQuery();
		System.out.println("\n\n:: LISTA DE USUARIOS ::");
		while(resultado.next()) {
			System.out.println("\n  Nome: " + resultado.getString("nome"));
			System.out.println("  Email: " + resultado.getString("email"));
			System.out.println("  CPF: " + resultado.getString("cpf") + "\n\n");
		}
		
		declaracao.close();
		fecharConexao();
	}

}
