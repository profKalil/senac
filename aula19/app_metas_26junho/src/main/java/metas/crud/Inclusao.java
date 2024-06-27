package metas.crud;

import java.sql.*;

public class Inclusao extends Conexao {
	private PreparedStatement declaracao;

	public void incluirUsuario(String cpf, String nome, String senha, String email) throws SQLException {
		conectar();
		declaracao = getConexao().prepareStatement("INSERT INTO tb_usuario (cpf, nome, senha, email) VALUES (?,?,?,?)");
		declaracao.setString(1, cpf);
		declaracao.setString(2, nome);
		declaracao.setString(3, senha);
		declaracao.setString(4, email);
		declaracao.executeUpdate();
		System.out.println("Usuário adicionado com sucesso");
		declaracao.close();
		fecharConexao();
	}

	public void incluirMeta(String tipo, double valor, double acumulado, String cpf) throws SQLException {
		conectar();
		declaracao = getConexao()
				.prepareStatement("INSERT INTO tb_meta (tipo, valor, acumulado, cpf) VALUES (?,?,?,?)");
		declaracao.setString(1, tipo);
		declaracao.setDouble(2, valor);
		declaracao.setDouble(3, acumulado);
		declaracao.setString(4, cpf);
		declaracao.executeUpdate();
		System.out.println("Meta adicionada com sucesso");
		declaracao.close();
		fecharConexao();
	}

	public void incluirProgresso(double valor, int id_meta) throws SQLException {
		conectar();
		getConexao().setAutoCommit(false);
		declaracao = getConexao()
				.prepareStatement("INSERT INTO tb_progresso (valor, id_meta) VALUES (?,?)");
		declaracao.setDouble(1, valor);
		declaracao.setInt(2, id_meta);
		declaracao.executeUpdate();
		
		declaracao = getConexao()
				.prepareStatement("UPDATE tb_meta SET acumulado = acumulado + ? WHERE id = ?");
		declaracao.setDouble(1, valor);
		declaracao.setInt(2, id_meta);
		declaracao.executeUpdate();
		getConexao().commit();
		declaracao.close();
		System.out.println("Progresso adicionado com sucesso e meta atualizada");
		fecharConexao();
	}
}
