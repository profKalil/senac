package br.senac.aula03;

public class ManipulaString {

	public static void main(String[] args) {
		inicio();
}

	private static void inicio() {
		Tarefa t1 = new Tarefa("001", "Estudar Java", 10, 13);
		Tarefa t2 = new Tarefa("002", "Fazer compras", 11, 12);
		Tarefa t3 = new Tarefa("003", "Limpar a casa", 12, 13);
		
		
		System.out.println("O tempo da tarefa é " + (t1.getFim()-t1.getInicio()) + " hora");
		
	}
}