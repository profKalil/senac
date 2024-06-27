package metas.teste;

import java.sql.SQLException;
import java.util.List;

//import metas.crud.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import metas.jpa.Usuario;

public class Teste {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("metasPU");;
	private static EntityManager enm; 

	public static void main(String[] args) throws SQLException {
//		Inclusao i = new Inclusao();
//
//		//i.incluirUsuario("010.010.010-00", "Joao", "1234", "joao@email.com");
//		//i.incluirUsuario("110.010.010-00", "Maria", "1234", "maria@email.com");
//		// i.incluirMeta("Consórcio", 1000.00, 0.00, "010.010.010-00");		
//		// i.incluirProgresso(90.00, 5);
//		
//		//i.incluirUsuario("210.010.010-00", "Jose", "1234", "jose@email.com");
//		
//		Exclusao e = new Exclusao();
//		//e.excluirUsuario("010.010.010-00");
//		
//		Alteracao a = new Alteracao();
//		//a.alterarUsuario("010.010.010-00", "João das Couves", "joaodascouves@email.com");
//		
//		
//		Consulta c = new Consulta();
//		c.consultarTodos();

		//incluir();
		// consultar();
		//atualizar();
		//deletar("22345678900");

	}

	private static void deletar(String cpf) {
		enm = entityManagerFactory.createEntityManager();
		enm.getTransaction().begin();
		Usuario u = enm.find(Usuario.class, cpf);
		try {
			enm.remove(u);
			enm.getTransaction().commit();
			System.out.println("Usuario excluído com sucesso");
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			enm.close();
		}
		
	}

	private static void atualizar() {
		enm = entityManagerFactory.createEntityManager();
		enm.getTransaction().begin();
		Usuario u = new Usuario();
		u.setCpf("12345678900");
		u.setNome("João das Couves Silva");
		u.setSenha("senha123");
		u.setEmail("joaodascouvessilva@email.com");
		try {
			enm.merge(u);
			enm.getTransaction().commit();
			System.out.println("Usuario alterado com sucesso");
			
		} finally {
			enm.close();
		}
		
	}

	private static void consultar() {
		enm = entityManagerFactory.createEntityManager();
		 
		try {
			TypedQuery<Usuario> query = enm.createQuery("SELECT u FROM Usuario u", Usuario.class);
			List<Usuario> usuario = query.getResultList();
			
			
				System.out.println(usuario);
			
			
		} finally {
			enm.close();
		}
		
	}

	private static void incluir() {
		enm = entityManagerFactory.createEntityManager();
		 
		enm.getTransaction().begin();
		 
		Usuario usuario = new Usuario();
		usuario.setCpf("22345678900");
		usuario.setNome("Jose da Silva");
		usuario.setSenha("senha123");
		usuario.setEmail("jose.silva@email.com");

		 
		enm.persist(usuario);
		enm.getTransaction().commit();

		 
		enm.close();
		entityManagerFactory.close();

		System.out.println("Usuário criado com sucesso!");
		
	}
	
	
}
