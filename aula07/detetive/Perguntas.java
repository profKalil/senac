package detetive;

import java.util.Scanner;

public class Perguntas {
	private final String PERG1 = "Telefonou para a vítima?";
	private final String PERG2 = "Esteve no local do crime?";
	private final String PERG3 = "Mora perto da vítima?";
	private final String PERG4 = "Devia para a vítima?";
	private final String PERG5 = "Já trabalhou para a vítima?";
	public int contador=0;
	
	public Perguntas() {
		perguntar();
		System.out.println(veredito());
	}
	
	public void perguntar () {
		Scanner entrada = new Scanner(System.in);
		System.out.println(getPERG1());
		String resposta1 = entrada.next(); // sim Sim
		String sim="sim", Sim="Sim";
		if (resposta1.equals(Sim) || resposta1.equals(sim) ) {
			this.contador++;
		}
		System.out.println(getPERG2());
		String resposta2 = entrada.next(); 
		if (resposta2.equals(Sim) || resposta2.equals(sim) ) {
			this.contador++;
		}
		System.out.println(getPERG3());
		String resposta3 = entrada.next();
		if (resposta3.equals(Sim) || resposta3.equals(sim) ) {
			this.contador++;
		}
		System.out.println(getPERG4());
		String resposta4 = entrada.next();
		if (resposta4.equals(Sim) || resposta4.equals(sim) ) {
			this.contador++;
		}
		System.out.println(getPERG5());
		String resposta5 = entrada.next();
		if (resposta5.equals(Sim) || resposta5.equals(sim) ) {
			this.contador++;
		}
		entrada.close();
	}
	
	
	private String veredito() {
		if (this.contador == 5) {
			return "Assasino";
		} else if (this.contador==4 || this.contador==3) {
			return "Cumplice";
		} else if (this.contador==2) {
			return "Suspeito";
		} return "Inocente";
	}
	
	private String getPERG1() {
		return PERG1;
	}
	private String getPERG2() {
		return PERG2;
	}
	private String getPERG3() {
		return PERG3;
	}
	private String getPERG4() {
		return PERG4;
	}
	private String getPERG5() {
		return PERG5;
	}
	
}
