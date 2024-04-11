package br.senac.olamundointerface;
import javax.swing.*;

public class Janela extends JFrame {
	public Janela() {
		super("Minha Janela");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		JOptionPane.showMessageDialog(this, "Olá Mundo");
	}
}