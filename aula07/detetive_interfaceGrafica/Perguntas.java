package detetive;

import javax.swing.JOptionPane;

public class Perguntas {
	private final String PERG1 = "Telefonou para a vítima?";
	private final String PERG2 = "Esteve no local do crime?";
	private final String PERG3 = "Mora perto da vítima?";
	private final String PERG4 = "Devia para a vítima?";
	private final String PERG5 = "Já trabalhou para a vítima?";
	private int contador=0;
	
	public Perguntas() {
		perguntar();
		JOptionPane.showMessageDialog(null, veredito());
	}
	
	public void perguntar () {
		String resposta1 = String.valueOf(JOptionPane.showConfirmDialog(null, getPERG1()));
		String sim="0";
		if (resposta1.equals(sim) ) {
			setContador(1);
		}
		String resposta2 = String.valueOf(JOptionPane.showConfirmDialog(null, getPERG2())); 
		if (resposta2.equals(sim) ) {
			setContador(1);
		}
		String resposta3 = String.valueOf(JOptionPane.showConfirmDialog(null, getPERG3()));
		if (resposta3.equals(sim) ) {
			setContador(1);
		}
		String resposta4 = String.valueOf(JOptionPane.showConfirmDialog(null, getPERG4()));
		if (resposta4.equals(sim) ) {
			setContador(1);
		}
		String resposta5 = String.valueOf(JOptionPane.showConfirmDialog(null, getPERG5()));
		if (resposta5.equals(sim) ) {
			setContador(1);
		}
	}
	
	private String veredito() {
		if (getContador() == 5) {
			return "Assasino";
		} else if (getContador()==4 || getContador()==3) {
			return "Cumplice";
		} else if (getContador()==2) {
			return "Suspeito";
		} return "Inocente";
	}
	
	private void setContador(int i) {
		this.contador=this.contador+i;
	}
	private int getContador() {
		return this.contador;
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
