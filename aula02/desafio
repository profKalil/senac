package br.senac.aula02;

public class ManipulaString {

	public static void main(String[] args) {
		inicio();
	}

	private static void inicio() {
		String tarefa = "";
		int tempo = 8;
		
		tarefa = cadastrarTarefa ("001", "Estudar Java", 10, 11, (tempo-=calculaHora(10, 11)));
		tarefa += cadastrarTarefa ("002", "Fazer compras", 11, 12, (tempo-=calculaHora(11, 12)));
		tarefa += cadastrarTarefa ("003", "Limpar a casa", 12, 13, (tempo-=calculaHora(12, 13)));
				
		System.out.println("Cod - Tarefa - Inicio - Fim - Tempo Restante");
		System.out.println(tarefa);
		
	}

	private static String cadastrarTarefa(String cod, String tarefa, int inicio, int fim, int tempo) {
		
		return (cod + " - " + tarefa + " - " + inicio + " - " + fim + " - " + tempo + "\n");
	}

	private static int calculaHora(int inicio, int fim) {
		 
		return fim-inicio;
	}

}
