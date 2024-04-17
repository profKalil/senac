package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import controller.CadastroController;

public class CadastroView extends JFrame {
	
	private CadastroController controller = new CadastroController();
	
	public CadastroView() {
		setNomeView();
		getNomeView();
	}
	
	public void setNomeView() {
		controller.setNomeController(JOptionPane.showInputDialog(null, "Seu nome :"));
	}
	public void getNomeView() {
		JOptionPane.showMessageDialog(null, ("Bem-vindo, "+controller.getNomeController()));
	}
}
