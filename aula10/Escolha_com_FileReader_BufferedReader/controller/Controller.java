package controller;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
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
			boolean condicao = verificarMatricula(matricula);
			if (matriculasVotadas.contains(matricula)) {
				mensagemView.exibirMensagem("Este aluno já fez sua escolha!");
			} else if (destinoEscolhido != null && matricula != null && condicao) {
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
				matriculasVotadas += matricula.toString();
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
		this.votos = getNumeroDeAlunos();

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
		}, 60* 60 * 1000);
	}

	public void setDestino(DestinoModel d) {
		this.destino.add(d);
	}

	private int getNumeroDeAlunos() {
		int numeroDeAlunos = 0;
		try (BufferedReader reader = new BufferedReader(
				new FileReader("C:\\Users\\Windows\\Desktop\\programas_java\\Escolha\\src\\controller\\alunos.txt"))) {
			while (reader.readLine() != null) {
				numeroDeAlunos++;
			}
		} catch (Exception erro) {
			erro.printStackTrace();
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

	public boolean verificarMatricula(String matricula) {
		boolean condicao = false;
		try (BufferedReader reader = new BufferedReader(
				new FileReader("C:\\Users\\Windows\\Desktop\\programas_java\\Escolha\\src\\controller\\matricula.txt"))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				linha = linha.replaceAll("[^0-9]", "");
				String matriculaArquivo = linha.trim();
				System.out.println(matriculaArquivo);
				if (matricula.equals(matriculaArquivo)) {
					condicao = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return condicao;
	}
}