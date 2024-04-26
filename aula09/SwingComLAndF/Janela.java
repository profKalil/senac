import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Janela extends JFrame {

    // Atributos botões
    private JButton btnCortar, btnCopiar, btnColar;
    private JButton btnMetal, btnMac, btnMotif, btnWin;
    
    // Evento pelo modo lambda
    private ActionListener ouvinte = (ActionEvent evento) -> {
        if (evento.getSource()==btnCopiar) {
            System.out.println("Copiar");
        } else {
             System.out.println(evento.getActionCommand());
        }
    };

    // Construtor da classe Janela
    public Janela() {

        super("Estudando Swing"); // Titulo da janela usando construtor da classe pai
        setSize(450, 250); // Tamanho pré-definido da janela
        setDefaultCloseOperation(EXIT_ON_CLOSE);  // Ativa fechamento da operação
        setLocationRelativeTo(null);  // A Janela abre exatamente no centro da tela
        setResizable(false);  // Impossibilita redimensionar a janela

        /*
         * BLOCO 1
         */

        JPanel bloco = new JPanel();  // Cria o primeiro bloco ou containner para receber componentes
        bloco.setLayout(new FlowLayout(FlowLayout.CENTER)); // o conteúdo do bloco será centralizado

        btnCortar = new JButton("Cortar"); // botao cortar é instanciado
        btnCortar.addActionListener(ouvinte);  // botao cortar recebe um ouvinte com evento
        bloco.add(btnCortar);  // botao cortar é adicionado

        btnCopiar = new JButton(" ", new ImageIcon("src/copy.png")); // copiar só tem imagem
        btnCopiar.addActionListener(ouvinte);
        bloco.add(btnCopiar);

        btnColar = new JButton("Colar");
        btnColar.addActionListener(ouvinte);
        bloco.add(btnColar);

        add(bloco, BorderLayout.NORTH); // bloco adicionado na parte superior da janela

        /*
         * BLOCO 2
         */

        JPanel bloco2 = new JPanel(); 

        EventoLAndF ouvinte2 = new EventoLAndF(this); // Ouvinte com evento é instanciado

        btnMac = new JButton("Mac");
        btnMac.addActionListener(ouvinte2);
        bloco2.add(btnMac);

        btnMetal = new JButton("Metal");
        btnMetal.addActionListener(ouvinte2);
        bloco2.add(btnMetal);

        btnMotif = new JButton("Motif");
        btnMotif.addActionListener(ouvinte2);
        bloco2.add(btnMotif);

        btnWin = new JButton("Windows");
        btnWin.addActionListener(ouvinte2);
        bloco2.add(btnWin);

        add(bloco2, BorderLayout.SOUTH); // Bloco 2 é adicionado na parte inferior da janela
        
        setVisible(true); // Janela fica visível
    }
}
