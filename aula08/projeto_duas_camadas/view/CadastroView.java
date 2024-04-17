package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.CadastroModel;

public class CadastroView extends JFrame {
	
	CadastroModel m = new CadastroModel();
	
	public void setNomeView () {
		m.setModelNome(JOptionPane.showInputDialog(null, "Seu nome:"));
	}
	
	public String getNomeView() {
		return m.getModelNome();
	}
}
