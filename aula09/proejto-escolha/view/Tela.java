package escolha.view;

import java.awt.event.ActionListener;

import javax.swing.*;

public class Tela {
	private JFrame janela;
	private JLabel lblMatricula;
	private JTextField txtMatricula;
	private JCheckBox chkDestino1;
	private JCheckBox chkDestino2;
	private JCheckBox chkDestino3;
	private JButton btnConfirmar;
	private JLabel lblImg1;
	private JLabel lblImg2;
	private JLabel lblImg3;
	
	public Tela() {
		
		janela = new JFrame("Informe sua matrícula e escolha seu destino!");
		janela.setSize(800, 600);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setLayout(null);
		janela.setResizable(false);
		
		lblMatricula = new JLabel("Matrícula");
		lblMatricula.setBounds(100,45,80,25);
		janela.add(lblMatricula);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(180, 45, 400, 25);
		janela.add(txtMatricula);
		
		ButtonGroup grupoDestinos = new ButtonGroup();
		
		chkDestino1 = new JCheckBox("Rio de Janeiro");
		chkDestino1.setBounds(100, 140, 150, 25);
		grupoDestinos.add(chkDestino1);
		janela.add(chkDestino1);
		
		lblImg1 = new JLabel(new ImageIcon("C:\\Users\\professor\\Desktop\\java\\Escolha\\src\\escolha\\rio.jpg"));
		lblImg1.setBounds(250, 110, 390, 130);
		janela.add(lblImg1);
		
		chkDestino2 = new JCheckBox("Salvador");
		chkDestino2.setBounds(100, 290, 150, 25);
		grupoDestinos.add(chkDestino2);
		janela.add(chkDestino2);
		
		lblImg2 = new JLabel(new ImageIcon("C:\\Users\\professor\\Desktop\\java\\Escolha\\src\\escolha\\salvador.jpg"));
		lblImg2.setBounds(250, 260, 390, 130);
		janela.add(lblImg2);
		
		chkDestino3 = new JCheckBox("Florianópolis");
		chkDestino3.setBounds(100, 440, 150, 25);
		grupoDestinos.add(chkDestino3);
		janela.add(chkDestino3);
		
		lblImg3 = new JLabel(new ImageIcon("C:\\Users\\professor\\Desktop\\java\\Escolha\\src\\escolha\\florianopolis.jpg"));
		lblImg3.setBounds(250, 410, 390, 130);
		janela.add(lblImg3);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(600, 45, 100, 25);
		janela.add(btnConfirmar);
		
		janela.setVisible(true);
	}
	
	public int getMatricula() {
		return Integer.parseInt(txtMatricula.getText());
	}
	
	public String getDestinoEscolhido() {
		if (chkDestino1.isSelected()) {
			return "Rio de Janeiro";
		} else if(chkDestino2.isSelected()) {
			return "Salvador";
		} else if (chkDestino3.isSelected()) {
			return "Florianópolis";
		} else {
			return null;
		}
	}
	
	public void setMensagem(String mensagem) {
		JOptionPane.showConfirmDialog (janela, mensagem);
	}
	
	public void eventoBotao (ActionListener ouvinte) {
		btnConfirmar.addActionListener(ouvinte);
	}
}
