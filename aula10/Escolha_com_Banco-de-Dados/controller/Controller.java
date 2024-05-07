package controller;

import java.awt.event.*;
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
	private List<String> arrayMatricula = new ArrayList<>();

	private ActionListener ouvinteBotao = (ActionEvent ae) -> {
		try {
			String matricula = tela.getMatricula();
			String destino1 = "Rio de Janeiro", destino2 = "Salvador";
			String destinoEscolhido = tela.getDestinoEscolhido();
			boolean condicao=false;

			for (int i = 0; i < arrayMatricula.size(); i++) {
				if (arrayMatricula.get(i).equals(matricula)) {
					condicao = true;
					break;
				}
			}

			if (condicao) {
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
				arrayMatricula.add(matricula);

				if (votos == 0) {
					finalizarEscolha();
				} else {
					mensagemView.exibirMensagem("Obrigado por participar. Aguarde os outros alunos votarem.");
				}
			} else {
				mensagemView.exibirMensagem("Erro. Verifique matricula ou destino");
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
		}, 60 * 1000);
	}

	public void setDestino(DestinoModel d) {
		this.destino.add(d);
	}

	private int getNumeroDeAlunosDB() {
		int numeroDeAlunos = 0;
		try {
			Connection conexaoSQL = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_escolha", "root",
					"1234");
			Statement codigoSQL = conexaoSQL.createStatement();
			ResultSet execucaoSQL = codigoSQL.executeQuery("SELECT COUNT(*) FROM alunos");

			if (execucaoSQL.next()) {
				numeroDeAlunos = execucaoSQL.getInt(1); // getInt(matricula) ou getString(nome)
			}

			execucaoSQL.close();
			codigoSQL.close();
			conexaoSQL.close();

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
			Connection conexaoSQL = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_escolha", "root",
					"1234");
			Statement codigoSQL = conexaoSQL.createStatement();
			ResultSet execucaoSQL = codigoSQL.executeQuery("SELECT matricula FROM alunos");

			while (execucaoSQL.next()) {
				if (matricula.equals(execucaoSQL.getString(1).trim())) {
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
