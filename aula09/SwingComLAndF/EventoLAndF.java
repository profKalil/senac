import java.awt.event.*;
import javax.swing.*;

// Implementando a interface ActionListener para a lógica da Aparência e Comportamento(L&F)
public class EventoLAndF implements ActionListener {
    
    //Atributo
    private JFrame bloco = new JFrame();

    //Construtor
    public EventoLAndF(JFrame f) {
        this.bloco = f;
    }

    @Override // Sobrescrita de um método
    public void actionPerformed(ActionEvent e) {
        
        String aparencia = null; // variável que vai receber um L&F
         
        // Bloco if-else para definir o que fazer quando o botão é pressionado
        if (e.getActionCommand().equals("Mac")) {  // compara o text do btn com um valor
            aparencia = "javax.swing.plaf.mac.MacLookAndFeel";  // guarda um endereço
        } else if (e.getActionCommand().equals("Metal")) {
            aparencia = "javax.swing.plaf.metal.MetalLookAndFeel";
        } else if (e.getActionCommand().equals("Motif")) {
            aparencia = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
        } else if (e.getActionCommand().equals("Windows")) {
            aparencia = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        } 

        // Bloco try-catch para modificar a aparência da tela
        try {
            UIManager.setLookAndFeel(aparencia);  // altera a aparencia do UI (Tela)
            SwingUtilities.updateComponentTreeUI(bloco);  // atualiza a janela para a nova aparência

            // Se falhar, imprime o erro
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, err);
        }
    }

}
