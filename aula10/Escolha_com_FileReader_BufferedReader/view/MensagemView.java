package view;

import javax.swing.*;

public class MensagemView {
	private JFrame janela;
	private JLabel lblMensagem;

	public MensagemView() {
		janela = new JFrame("Mensagem");
		janela.setSize(400, 100);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
		janela.setLayout(null);

		lblMensagem = new JLabel();
		lblMensagem.setBounds(20, 20, 350, 25);
		janela.add(lblMensagem);

		janela.setVisible(false);
	}

	public void exibirMensagem(String mensagem) {
		lblMensagem.setText(mensagem);
		janela.setVisible(true);
	}
}