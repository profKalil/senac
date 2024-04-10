package br.senac.manipulacaodedatas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Aniversario {
	private LocalDate nascimento;

	public long idade(LocalDate nascimento) {
		setNascimento(nascimento);
		LocalDate dataAtual = LocalDate.now();
		return ChronoUnit.YEARS.between(getNascimento(), dataAtual);
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

}
