package br.senac.manipulacaodedatas;

import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {
		Aniversario niver = new Aniversario();
		LocalDate nascimento = LocalDate.of(2023, 3, 9);
		long idade = niver.idade(nascimento);
		System.out.println("Sua idade é " + idade + " ano(s)");
	}

}
