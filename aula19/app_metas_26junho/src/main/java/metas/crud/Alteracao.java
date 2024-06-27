package metas.crud;

import java.sql.*;

public class Alteracao extends Conexao {
	private PreparedStatement declaracao;
	
	public void alterarUsuario(String cpf, String nome, String email) throws SQLException {
		
		conectar();
		declaracao = getConexao().prepareStatement("UPDATE tb_usuario SET nome = ?, email = ? WHERE cpf = ? ");
		declaracao.setString(1, nome);
		declaracao.setString(2, email);
		declaracao.setString(3, cpf);
		declaracao.executeUpdate();
		System.out.println("Alteração realizada com sucesso!");
		declaracao.close();
		fecharConexao();
	}

}
