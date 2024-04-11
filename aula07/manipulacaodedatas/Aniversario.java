package br.senac.manipulacaodedatas;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Aniversario {
	private LocalDate nascimento;

	public Aniversario() {
		Scanner sc = new Scanner(System.in);
		boolean ficar = true;
		while (ficar) {
			try {
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				System.out.print("Seu nascimento (dia/mes/ano) : ");
				String entrada = sc.next();
				if (entrada.matches("\\d{2}/\\d{2}/\\d{4}")) {
					String nascimento = String.valueOf(LocalDate.parse(entrada, formato));
					long idade = idade(nascimento);
					System.out.println("Sua idade é " + idade + " ano(s)");
				} else {
					System.out.println("Formato incorreto");
				}
			} catch (Exception e) {
				System.out.println("Houve uma exceção" + e);
			} finally {
				System.out.print("Digite \"sim\" para sair ou qualquer letra pra ficar: ");
				String fim = "sim";
				String opcao = sc.next();
				if (opcao.equals(fim)) {
					System.out.println("Programa encerrado");
					ficar = false;
					sc.close();
				}
			}
		}

	}

	public long idade(String nascimento) {
		setNascimento(nascimento);
		LocalDate dataAtual = LocalDate.now();
		return ChronoUnit.YEARS.between(getNascimento(), dataAtual);
	}

	private LocalDate getNascimento() {
		return nascimento;
	}

	private void setNascimento(String nascimento) {
		try {
			this.nascimento = LocalDate.parse(nascimento);
		} catch (Exception e) {
			this.nascimento = LocalDate.now();
			System.out.println(e);
		}
	}
}
