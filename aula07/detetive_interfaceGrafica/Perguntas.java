package detetive;

import javax.swing.JOptionPane;

public class Perguntas extends JOptionPane {
	private final String PERG1 = "Telefonou para a vítima?";
	private final String PERG2 = "Esteve no local do crime?";
	private final String PERG3 = "Mora perto da vítima?";
	private final String PERG4 = "Devia para a vítima?";
	private final String PERG5 = "Já trabalhou para a vítima?";
	private int contador=0;
	
	public Perguntas() {
		perguntar();
		showMessageDialog(null, veredito());
	}
	
	public void perguntar () {
		
		if (showConfirmDialog(null, getPERG1())==0) {
			setContador(1);
		}
		if (showConfirmDialog(null, getPERG2())==0) {
			setContador(1);
		}
		if (showConfirmDialog(null, getPERG3())==0) {
			setContador(1);
		}
		if (showConfirmDialog(null, getPERG4())==0) {
			setContador(1);
		}
		if (showConfirmDialog(null, getPERG5())==0) {
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
