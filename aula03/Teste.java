package br.senac.aula03.objeto;

public class Teste {

	public static void main(String[] args) {
		FolhaDePagamento f = new FolhaDePagamento();
		/*f.salario = 100;
		f.desconto = 0;
		f.horasTrabalhadas = 160;
		
		double salarioFinal = f.salario * f.horasTrabalhadas;*/
		
		f.setSalario(100);
		f.setDesconto(0);
		f.setHorasTrabalhadas(160);
		
		double salarioFinal = f.getSalario() * f.getHorasTrabalhadas();
		
		System.out.printf("%.2f", salarioFinal);
		
	}

}
