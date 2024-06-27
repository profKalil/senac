package metas.crud;

import java.sql.*;

public class Exclusao extends Conexao {
	private PreparedStatement declaracao;
	
	public void excluirUsuario(String cpf) throws SQLException {
		conectar();
		getConexao().setAutoCommit(false);
		declaracao = getConexao().prepareStatement("DELETE FROM tb_progresso WHERE id_meta IN (SELECT id FROM tb_meta WHERE cpf = ?)");
		declaracao.setString(1, cpf);
		declaracao.executeUpdate();
		declaracao = getConexao().prepareStatement("DELETE FROM tb_meta WHERE cpf = ?");
		declaracao.setString(1, cpf);
		declaracao.executeUpdate();
		declaracao = getConexao().prepareStatement("DELETE FROM tb_usuario WHERE cpf=?");
		declaracao.setString(1, cpf);
		declaracao.executeUpdate();
		declaracao.close();
		getConexao().commit();
		System.out.println("Usuário excluído com sucesso!");
		fecharConexao();
	}
}
