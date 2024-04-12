package detetive;

import javax.swing.JOptionPane;

public class Perguntas {
	private final String PERG1 = "Telefonou para a vítima?";
	private final String PERG2 = "Esteve no local do crime?";
	private final String PERG3 = "Mora perto da vítima?";
	private final String PERG4 = "Devia para a vítima?";
	private final String PERG5 = "Já trabalhou para a vítima?";
	public int contador=0;
	
	public Perguntas() {
		perguntar();
		JOptionPane.showMessageDialog(null, veredito());
	}
	
	public void perguntar () {
		
		String resposta1 = String.valueOf(JOptionPane.showConfirmDialog(null, getPERG1()));
		String sim="0";
		if (resposta1.equals(sim) ) {
			this.contador++;
		}
		String resposta2 = String.valueOf(JOptionPane.showConfirmDialog(null, getPERG2())); 
		if (resposta2.equals(sim) ) {
			this.contador++;
		}
		String resposta3 = String.valueOf(JOptionPane.showConfirmDialog(null, getPERG3()));
		if (resposta3.equals(sim) ) {
			this.contador++;
		}
		String resposta4 = String.valueOf(JOptionPane.showConfirmDialog(null, getPERG4()));
		if (resposta4.equals(sim) ) {
			this.contador++;
		}
		String resposta5 = String.valueOf(JOptionPane.showConfirmDialog(null, getPERG5()));
		if (resposta5.equals(sim) ) {
			this.contador++;
		}
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
