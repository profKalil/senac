package escolhe;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Escolhe extends JFrame {

	private String[] listaAlunos = { 
			"ADÃO",
			"ANDRÉ",
			"ARTHUR",
			"CARLOS",
			"CHRISTOPHER",
			"DANIEL",
			"DEIVID",
			"EDUARDO",
			"ELDER",
			"EMANUEL",
			"ERICK",
			"FRANCISCO",
			"GABRIEL DIAS",
			"GABRIEL ZIMMERMANN",
			"GRÉGORI",
			"GUILHERME",
			"GUSTAVO",
			"HEITOR",
			"HENRIQUE",
			"JOICY",
			"JÚLIO",
			"LAVÍNIA",
			"LUCAS",
			"LUIZ", 
			"MARCOLINO",
			"PAULO",
			"PETTER",
			"RAFAELA",
			"RAIKA",
			"RANIERI",
			"VITOR",
			"WELLIGTON"};
	private List <Integer>alunoEscolhido = new ArrayList<>();
	private JLabel[] listaLblAlunos;
	private JPanel pnlListaAlunos;
	private int sorteio =  0;

	public Escolhe() {
		inicio();
	}

	private void inicio() {
		setTitle("Escolhe um aluno");
		setSize(1200, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(carregaLista());
		setVisible(true);
		int parada = listaAlunos.length +1;
		while (parada !=0) {
			String aluno = randomAluno();
			riscaNome(JOptionPane.showConfirmDialog(this, "Aluno escolhido : " + aluno), aluno);
			parada--;
		}
	}

	private void riscaNome(int retorno, String aluno) {
		for (int i=0; i<listaAlunos.length; i++) {
			 if (retorno==0) {
				 if (listaLblAlunos[i].getText().equals(aluno)) {
					 listaLblAlunos[i].setFont(new Font("Arial", Font.BOLD, 18));
					 listaLblAlunos[i].setText(">" + aluno + "<");
				 }
			 }
		 }
		pnlListaAlunos.revalidate();
	    pnlListaAlunos.repaint();
	}

	private JPanel carregaLista() { 
		int x = listaAlunos.length;
		pnlListaAlunos = new JPanel(new GridLayout(x/3, 3)); 
		listaLblAlunos = new JLabel[listaAlunos.length];
		Font f = new Font("Arial", Font.PLAIN, 18);
		for (int i=0; i<listaAlunos.length; i++) { 
			listaLblAlunos[i] = new JLabel( );
			listaLblAlunos[i].setText(listaAlunos[i]);
			listaLblAlunos[i].setFont(f);
			listaLblAlunos[i].setHorizontalAlignment(JLabel.CENTER);
			pnlListaAlunos.add(listaLblAlunos[i]);
		}
		return pnlListaAlunos;
	}

	private String randomAluno() {
		Random r = new Random();
		if (alunoEscolhido.size()==listaAlunos.length) {
			return "Clique em \"X\" para encerrar!";
		}
			while(alunoEscolhido.contains(sorteio)) {
				sorteio = r.nextInt(listaAlunos.length);
			}
			alunoEscolhido.add(sorteio);
		return listaAlunos[sorteio];
	}

	public static void main(String[] args) {
		new Escolhe();
		
	}

}