package controller;

import java.awt.event.*;
/*import java.io.BufferedReader;
import java.io.FileReader;*/
import java.sql.*;
import java.util.*;

import model.*;
import view.*;

public class Controller {
	private Tela tela;
	private MensagemView mensagemView;
	private AlunoModel alunoModel;
	private List<DestinoModel> destino;
	private Integer votos = null;
	private Timer timer;
	private int rio = 0;
	private int salvador = 0;
	private int floripa = 0;
	private String matriculasVotadas = "";

	private ActionListener ouvinteBotao = (ActionEvent ae) -> {
		try {
			String matricula = tela.getMatricula();
			String destino1 = "Rio de Janeiro", destino2 = "Salvador";
			String destinoEscolhido = tela.getDestinoEscolhido(); 

			if (matriculasVotadas.equals(matricula)) {
				mensagemView.exibirMensagem("Esse aluno já votou!");
			} else if (destinoEscolhido != null && matricula != null && verificarMatriculaDB(matricula)) {

				alunoModel = new AlunoModel(Integer.parseInt(matricula));
				alunoModel.setDestinoEscolhido(destinoEscolhido);

				if (destinoEscolhido.equals(destino1)) {
					rio++;
				} else if (destinoEscolhido.equals(destino2)) {
					salvador++;
				} else {
					floripa++;
				}
				votos--;
				matriculasVotadas += matricula;
				if (votos == 0) {
					finalizarEscolha();
				} else {
					mensagemView.exibirMensagem("Obrigado por participar. Aguarde os outros alunos votarem.");
				}
			} else {
				mensagemView.exibirMensagem("Selecione um destino e informe sua matrícula!");
			}
		} catch (Exception err) {
			mensagemView.exibirMensagem("Verifique sua matrícula");
		}
	};

	public Controller() {
		this.tela = new Tela();
		this.mensagemView = new MensagemView();
		this.destino = new ArrayList<>();
		this.votos = getNumeroDeAlunosDB();

		setDestino(new DestinoModel("Rio de Janeiro"));
		setDestino(new DestinoModel("Salvador"));
		setDestino(new DestinoModel("Florianópolis"));

		tela.eventoBotao(ouvinteBotao);

		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				finalizarEscolha();
			}
		}, 60 * 60 * 1000);
	}

	public void setDestino(DestinoModel d) {
		this.destino.add(d);
	}

	private int getNumeroDeAlunosDB() {
		int numeroDeAlunos = 0;
		try {
			Connection conexaoSQL = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_escolha", "root", "1234");
			Statement codigoSQL = conexaoSQL.createStatement();
			ResultSet execucaoSQL = codigoSQL.executeQuery("SELECT COUNT(*) FROM alunos");

			if (executaSQL.next()) {
				numeroDeAlunos = execucaoSQL.getInt(1); // getInt(matricula) ou getString(nome)
			}

			executacaoSQL.close();
			codigoSQL.close();
			execucaoSQL.close();

		} catch (Exception erro) {
			System.out.println(erro); 
		}
		return numeroDeAlunos;
	}
	
	private String resultado() {

		int maiorVotos = Math.max(rio, Math.max(salvador, floripa));

		if (maiorVotos == rio) {
			return "Rio de Janeiro";
		} else if (maiorVotos == salvador) {
			return "Salvador";
		} else {
			return "Florianópolis";
		}

	}

	private void finalizarEscolha() {
		mensagemView.exibirMensagem("Votação encerrada. Resultado: " + resultado());
	}

	public boolean verificarMatriculaDB(String matricula) {
		boolean condicao = false;
		try {
			Connection conexaoSQL = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_escolha", "root", "1234");
			Statement codigoSQL = conexaoSQL.createStatement();
			ResultSet execucaoSQL = codigoSQL.executeQuery("SELECT matricula FROM alunos");
		
			String linha, matriculaArquivo;
			while (execucaoSQL.next()) {
				linha = Integer.toString( execucaoSQL.getInt(matricula) );				 
				matriculaArquivo = linha.trim();				 
				if (matricula.equals(matriculaArquivo)) {
					condicao = true;
					break;
				}
			}
			execucaoSQL.close();
			codigoSQL.close();
			conexaoSQL.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return condicao;
	}
}
